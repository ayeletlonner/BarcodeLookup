import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class BarcodeLookupComponent  extends JFrame{

    private BarcodeLookupClient client;
    private JPanel mainPanel = new JPanel(new BorderLayout(50, 50));
    private JTextArea textArea = new JTextArea();
    private JLabel imageLabel = new JLabel();
    private JPanel imagePanel = new JPanel(new BorderLayout());
    private JLabel imageNumber = new JLabel("No Image");
    private JPanel searchPanel = new JPanel(new FlowLayout());
    private JTextField textField = new JTextField();
    private JList productList = new JList();
    private Products products;
    private String[] urls;
    private int productIndex;
    private int imageIndex;
    private Disposable disposable;

    public BarcodeLookupComponent(BarcodeLookupClient client) {
        this.client = client;
        productIndex = 0;
        imageIndex = 0;
        setupMainPanel();
    }

    public void setProducts(BarcodeLookupObject barcodeLookupObject) {
        products =  barcodeLookupObject.getProducts();
        setProductList();
        setImageLabel();
        setTextArea();
    }

    public JPanel getComponent() {
        return mainPanel;
    }

    public void setupMainPanel() {
        setupSearchPanel();
        setupScrollPane();
        setupImagePanel();
        setupTextArea();
    }

    private void setupSearchPanel() {
        textField.setColumns(10);
        JButton barcodeButton = new JButton("Search by barcode");
        JButton productNameButton = new JButton("Search by product name");
        barcodeButton.addActionListener(e -> barcodeButtonClicked());
        productNameButton.addActionListener(e -> productNameButtonClicked());
        searchPanel.add(textField);
        searchPanel.add(barcodeButton);
        searchPanel.add(productNameButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
    }

    private void setupTextArea() {
        textArea.setMinimumSize(new Dimension(400, 700));
        textArea.setPreferredSize(new Dimension(400, 700));
        textArea.setMaximumSize(new Dimension(400, 700));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(UIManager.getColor("Label.background"));
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setBorder(UIManager.getBorder("Label.border"));
        mainPanel.add(textArea, BorderLayout.EAST);
    }

    private void setupImagePanel() {
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        JPanel imageButtons = new JPanel(new FlowLayout());
        JButton nextImage = new JButton("Next Image");
        JButton previousImage = new JButton("Previous Image");
        previousImage.addActionListener(e -> {
            if (imageIndex > 0 && urls != null) {
                imageIndex--;
                setImageLabel();
            }
        });
        nextImage.addActionListener(e -> {
            if (urls != null && imageIndex < urls.length - 1) {
                imageIndex++;
                setImageLabel();
            }
        });
        imageButtons.add(previousImage);
        imageButtons.add(imageNumber);
        imageButtons.add(nextImage);
        imagePanel.add(imageButtons, BorderLayout.SOUTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
    }

    private void setupScrollPane() {
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setLayoutOrientation(JList.VERTICAL);
        productList.setVisibleRowCount(-1);
        JScrollPane scrollPane = new JScrollPane(productList);
        productList.addListSelectionListener(e -> {
            productIndex = productList.getSelectedIndex();
            setURLs();
            imageIndex = 0;
            setTextArea();
            setImageLabel();
        });
        mainPanel.add(scrollPane, BorderLayout.WEST);
    }

    private void setProductList() {
        productIndex = 0;
        imageIndex = 0;
        String[] productNames = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).getProductName();
        }
        productList.setListData(productNames);
        setURLs();
    }

    private void setImageLabel() {
        imageLabel.setText(null);
        try {
            if (urls != null && urls.length > 0) {
                imageLabel.setIcon(new ImageIcon(new URL(urls[imageIndex])));
                imageNumber.setText((imageIndex + 1) + "/" + urls.length);
            }
            else {
                setBlankImageLabel();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setURLs() {
        if (products != null && products.get(productIndex).getImages().length > 0) {
            urls = products.get(productIndex).getImages();
        }
        else {
            urls = null;
        }
    }

    private void setBlankScreen() {
        String[] noData = null;
        productList.setListData(noData);
        setBlankImageLabel();
        textArea.setText("");
    }

    private void setBlankImageLabel() {
        imageLabel.setIcon(null);
        imageLabel.setText("No products found");
        imageNumber.setText("No Image");
    }

    private void setTextArea() {
        textArea.setText(products.get(productIndex).toString());
    }

    private void barcodeButtonClicked() {
        client.setBarcode(textField.getText());
        disposable = client.searchByBarcode()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::setProducts, Throwable::printStackTrace);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                disposable.dispose();
            }
        });
    }

    private void productNameButtonClicked() {
        client.setProductName(textField.getText());
        disposable = client.searchByProductName()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::setProducts, Throwable::printStackTrace);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                disposable.dispose();
            }
        });
    }
}


import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BarcodeLookupComponent {

    private JPanel mainPanel = new JPanel(new BorderLayout(50, 50));
    private JTextArea textArea = new JTextArea();
    private JLabel imageLabel = new JLabel();
    private JPanel imagePanel = new JPanel(new BorderLayout());
    private JLabel imageNumber = new JLabel("No Image");
    private JPanel searchPanel = new JPanel(new FlowLayout());
    private JList productList = new JList();
    private Products products;
    private String[] urls;
    int productIndex;
    int imageIndex;

    public BarcodeLookupComponent() {
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

    private void setupMainPanel() {
        setupSearchPanel();
        setupScrollPane();
        setupImagePanel();
        setupTextArea();
    }

    private void setupSearchPanel() {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        JButton barcodeButton = new JButton("Search by barcode");
        JButton productNameButton = new JButton("Search by product name");
        barcodeButton.addActionListener(e -> {

            //setProductList();
            //TODO fix this to be a barcode search - specify search
        });
        productNameButton.addActionListener(e -> {
            //TODO fix this to be a product name search - specify search

            //setProductList();
        });
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
            if (imageIndex > 0 && products != null) {
                imageIndex--;
                setImageLabel();
            }
        });
        nextImage.addActionListener(e -> {
            if (products != null && imageIndex < urls.length - 1) {
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
            urls = products.get(productIndex).getImages();
            imageIndex = 0;
            setTextArea();
            setImageLabel();
            //TODO set photo and info etc
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
        urls = products.get(productIndex).getImages();
    }

    private void setImageLabel() {
        try {
            imageLabel.setIcon(new ImageIcon(new URL(urls[imageIndex])));
            imageNumber.setText((imageIndex + 1) + "/" + urls.length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setTextArea() {
        textArea.setText(products.get(productIndex).toString());
    }
}


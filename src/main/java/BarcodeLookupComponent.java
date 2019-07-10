import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URI;
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
    private JPanel textPanel = new JPanel(new BorderLayout());
    private Products products;
    private String[] urls;
    private int productIndex;
    private int imageIndex;
    private Disposable disposable;
    private DefaultTableModel model;
    private JTable storeTable;

    public BarcodeLookupComponent(BarcodeLookupClient client) {
        this.client = client;
        productIndex = 0;
        imageIndex = 0;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                disposable.dispose();
            }
        });
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
        setupTextAndStoreArea();
        setupStoresTable();
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

    private void setupTextAndStoreArea() {
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
        textPanel.add(textArea, BorderLayout.NORTH);
        mainPanel.add(textPanel, BorderLayout.EAST);
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
            imageIndex = 0;
            setURLs();
            setTextArea();
            setImageLabel();
            setStores();
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
        if (products != null && products.size() > 0
                && products.get(productIndex).getImages() != null
                && products.get(productIndex).getImages().length > 0)
        {
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
        imageLabel.setText("No image found");
        imageNumber.setText("No Image");
    }

    private void setTextArea() {
        textArea.setText(products.get(productIndex).toString());
    }

    private void setupStoresTable() {

        String[] columns = new String[]{"Store Name", "Price", "URL"};
        model = new DefaultTableModel(new String[0][3], columns);
        storeTable = new JTable(model);
        storeTable.setFocusable(true);
        storeTable.setRowSelectionAllowed(true);
        storeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        textPanel.add(storeTable, BorderLayout.SOUTH);

        storeTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                int col = table.columnAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && col == 2) {
                    try {
                        String str = table.getValueAt(row, col).toString();
                        Desktop.getDesktop().browse(new URI(str));

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void setStores() {
        model.setRowCount(0);
        Stores stores = products.get(productIndex).getStores();

        if (stores != null && stores.size() > 0) {
            model.setRowCount(stores.size());
            for (int i = 0; i < stores.size(); i++) {
                Store store = stores.get(i);
                model.addRow(new String[] {store.getStore_name(), store.getStore_price(), store.getProduct_url()} );
            }
        }
        model.fireTableDataChanged();
    }

    private void barcodeButtonClicked() {
        disposable = client.searchByBarcode(textField.getText())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::setProducts, Throwable::printStackTrace);
    }

    private void productNameButtonClicked() {
        disposable = client.searchByProductName(textField.getText())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::setProducts, Throwable::printStackTrace);
    }
}


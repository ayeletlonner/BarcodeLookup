import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BarcodeLookupComponent {

    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JLabel imageLabel = new JLabel();
    private JPanel imagePanel = new JPanel(new BorderLayout());
    private JLabel imageNumber = new JLabel("1");
    private JPanel searchPanel = new JPanel(new FlowLayout());
    private JList productList = new JList();
    private Products products;
    private ArrayList<ImageIcon> images;
    int productIndex;
    int imageIndex;

    public BarcodeLookupComponent() {
        productIndex = 0;
        imageIndex = 0;
        setMainPanel();
    }

    private void setMainPanel() {
        setSearchPanel();
        setImagePanel();
    }

    private void setSearchPanel() {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        JButton barcodeButton = new JButton("Search by barcode");
        JButton productNameButton = new JButton("Search by product name");
        barcodeButton.addActionListener(e -> {
            productIndex = 0;
            imageIndex = 0;

            //setProductList();
            //TODO fix this to be a barcode search - specify search
        });
        productNameButton.addActionListener(e -> {
            //TODO fix this to be a product name search - specify search
            productIndex = 0;
            imageIndex = 0;

            //setProductList();
        });
        searchPanel.add(textField);
        searchPanel.add(barcodeButton);
        searchPanel.add(productNameButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
    }

    public void setProducts(Object products) {
        this.products = (Products) products;
        setProductList();
        setImageLabel();
    }

    /*private void setImages() {
        for (int i = 0; i < products.get(productIndex).getImages().length; i++) {
            try {
                images.add(new ImageIcon(new URL(products.get(productIndex).getImages()[i])));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }*/

    public JPanel getComponent() {
        return mainPanel;
    }

    private void setProductList() {
        String[] productNames = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).getProductName();
        }
        productList.setListData(productNames);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setLayoutOrientation(JList.VERTICAL);
        productList.setVisibleRowCount(-1);
        JScrollPane scrollPane = new JScrollPane(productList);
        productList.addListSelectionListener(e -> {
            productIndex = productList.getSelectedIndex();
            imageIndex = 0;
            setImageLabel();
            //TODO set photo and info etc
        });
        mainPanel.add(scrollPane, BorderLayout.EAST);
    }

    private void setImagePanel() {
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
            if (products != null && imageIndex < products.get(productIndex).getImages().length) {
                imageIndex++;
                setImageLabel();
            }
        });
        imageButtons.add(previousImage);
        imageButtons.add(imageNumber);
        imageButtons.add(nextImage);
        imagePanel.add(imageButtons, BorderLayout.SOUTH);
        mainPanel.add(imagePanel, BorderLayout.WEST);
    }

    private void setImageLabel() {
        try {
            imageLabel.setIcon(new ImageIcon(new URL(products.get(productIndex).getImages()[imageIndex])));
            imageNumber.setText(String.valueOf(imageIndex + 1));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


import javax.swing.*;
import java.awt.*;

public class BarcodeLookupFrame extends JFrame {

    private final int width = 1500;
    private final int height = 800;

    public BarcodeLookupFrame() {
        setTitle("Barcode Lookup");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        BarcodeLookupClient client = new BarcodeLookupClient();
        BarcodeLookupComponent component = new BarcodeLookupComponent(client);
        root.add(component.getComponent(), BorderLayout.CENTER);

        setContentPane(root);
    }

    public static void main(String[] args) {

        new BarcodeLookupFrame().setVisible(true);
    }
}

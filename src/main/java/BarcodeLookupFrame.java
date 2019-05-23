import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BarcodeLookupFrame extends JFrame {

    private final int width = 1200;
    private final int height = 800;

    public BarcodeLookupFrame() {
        setTitle("Barcode Lookup");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        BarcodeLookupComponent component = new BarcodeLookupComponent();
        root.add(component.getComponent(), BorderLayout.CENTER);


        BarcodeLookupClient client = new BarcodeLookupClient();
        Disposable disposable = client.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(component::setProducts, Throwable::printStackTrace);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                disposable.dispose();
            }
        });

        setContentPane(root);
    }

    public static void main(String[] args) {

        new BarcodeLookupFrame().setVisible(true);
    }
}

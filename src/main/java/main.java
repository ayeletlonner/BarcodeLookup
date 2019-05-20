import io.reactivex.disposables.Disposable;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        BarcodeLookupClient client = new BarcodeLookupClient();
        Disposable disposable = client.getProducts().subscribe(System.out::println);
    }
}

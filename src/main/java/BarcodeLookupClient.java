import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarcodeLookupClient {

    private final BarcodeLookupAPI api;
    private String productName;
    private String barcode;

    public BarcodeLookupClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.barcodelookup.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(BarcodeLookupAPI.class);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Observable<BarcodeLookupObject> searchByProductName() {
        return api.searchByProductName(productName);
    }

    public Observable<BarcodeLookupObject> searchByBarcode() {
        return api.searchByBarcode(barcode);
    }
}
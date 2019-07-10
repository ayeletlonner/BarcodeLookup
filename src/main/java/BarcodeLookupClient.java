import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarcodeLookupClient {

    private final BarcodeLookupAPI api;

    public BarcodeLookupClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.barcodelookup.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(BarcodeLookupAPI.class);
    }

    public Observable<BarcodeLookupObject> searchByProductName(String productName) {
        return api.searchByProductName(productName);
    }

    public Observable<BarcodeLookupObject> searchByBarcode(String barcode) {
        return api.searchByBarcode(barcode);
    }
}
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarcodeLookupClient {

    private final BarcodeLookupAPI api;

    public BarcodeLookupClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.barcodelookup.com")
                .addConverterFactory(GsonConverterFactory.create()) // is this unecessary because Barcode Lookup returns JSON???
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(BarcodeLookupAPI.class);
    }

    public Observable<BarcodeLookupObject> getProducts() {
        return api.getProducts();
    }
}
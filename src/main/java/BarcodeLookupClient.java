import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarcodeLookupClient {

    private final BarcodeLookupAPI api;

    public BarcodeLookupClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.barcodelookup.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(BarcodeLookupAPI.class);
    }

    public Observable<Products> getProducts() {
        return api.getProducts();
    }
}

//create retrofit api interface
//create pojos - things that the interface will return to you
//write a unit test or test in main where you instantiate retrofit, instantiate apis, make api calls, and make sure you get the data you want
//json to java converter - code beautify. give it url and it will return to you objects that you need to instantiate
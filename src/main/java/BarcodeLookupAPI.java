import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BarcodeLookupAPI {

    @GET("/v2/products?key=wk3hb4lglfw4kjbuanoicn9gs46ci4&product-name=Lego"
           // + "4hplyvf9ltuox6cgb83jun76hcaavd"
    )
    Observable<BarcodeLookupObject> getProducts();
}

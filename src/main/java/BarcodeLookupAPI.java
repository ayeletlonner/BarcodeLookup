import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BarcodeLookupAPI {

    @GET("/v2/products?key=4hplyvf9ltuox6cgb83jun76hcaavd&product-name=Lego")
    Observable<Object> getProducts();
}

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarcodeLookupAPI {

    @GET("/v2/products?key=35r1sqc7freen47yw62q11ww4kly1f&")
    Observable<BarcodeLookupObject> searchByProductName(@Query("product-name") String product_name);

    @GET("/v2/products?key=35r1sqc7freen47yw62q11ww4kly1f&")
    Observable<BarcodeLookupObject> searchByBarcode(@Query("barcode") String barcode);
}

//expired keys: 4hplyvf9ltuox6cgb83jun76hcaavd, wk3hb4lglfw4kjbuanoicn9gs46ci4

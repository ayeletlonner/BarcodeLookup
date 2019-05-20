import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BarcodeLookupAPI {

    @GET("products?formatted=y&key=4hplyvf9ltuox6cgb83jun76hcaavd&product-name=Lego")
    Observable<Products> getProducts();

    /*
    @GET("/users")
    Observable<UserList> getUserList();

    @GET("/photos")
    Observable<PhotoList> getPhotoList();
    */
}
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarcodeLookupAPI {

    @GET("/v2/products?key=r0jpjqlmeyg1ka1vlkmahj0r4sahzp&")
    Observable<BarcodeLookupObject> searchByProductName(@Query("product-name") String product_name);

    @GET("/v2/products?key=r0jpjqlmeyg1ka1vlkmahj0r4sahzp&")
    Observable<BarcodeLookupObject> searchByBarcode(@Query("barcode") String barcode);
}

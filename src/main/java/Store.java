public class Store {

    private String store_name, store_price, product_url, currency_code, currency_symbol;

    public String getStore_name() {
        return store_name;
    }

    public String getStore_price() {
        return store_price;
    }

    public String getProduct_url() {
        return product_url;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store_name='" + store_name + '\'' +
                ", store_price='" + store_price + '\'' +
                ", product_url='" + product_url + '\'' +
                ", currency_code='" + currency_code + '\'' +
                ", currency_symbol='" + currency_symbol + '\'' +
                '}';
    }
}

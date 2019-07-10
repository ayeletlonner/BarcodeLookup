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
        StringBuilder stringBuilder = new StringBuilder();

        if (store_name != null && !store_name.isEmpty()) {
            stringBuilder.append("\nStore Name: " + store_name);
        }

        if (store_price != null && !store_price.isEmpty()) {
            stringBuilder.append("\nStore Price: " + store_price);
        }

        if (product_url != null && !product_url.isEmpty()) {
            stringBuilder.append("\nProduct URL: " + product_url);
        }

        if (currency_code != null && !currency_code.isEmpty()) {
            stringBuilder.append("<\nCurrency Code: " + currency_code);
        }

        if (currency_symbol != null && !currency_symbol.isEmpty()) {
            stringBuilder.append("\nCurrency Symbol: " + currency_symbol + "\n");
        }

        return stringBuilder.toString();
    }
}

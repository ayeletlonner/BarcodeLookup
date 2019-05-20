import java.util.Arrays;

public class Product {

    private int barcode_number;
    private String barcode_type, barcode_formats, mpn, model, asin, product_name, title, category,
            manufacturer, brand, label, author, publisher, artist, actor, director, studio, genre, audience_rating,
            ingredients, nutrition_facts, color, format, package_quantity, size, length, width, height, weight,
            release_date, description;
    //private String[] features;
    //private String[] images;
    //private String[] stores;
    //private String[] reviews;


    @Override
    public String toString() {
        return "Product{" +
                "barcode_number=" + barcode_number +
                ", barcode_type='" + barcode_type + '\'' +
                ", barcode_formats='" + barcode_formats + '\'' +
                ", mpn='" + mpn + '\'' +
                ", model='" + model + '\'' +
                ", asin='" + asin + '\'' +
                ", product_name='" + product_name + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", brand='" + brand + '\'' +
                ", label='" + label + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", artist='" + artist + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", genre='" + genre + '\'' +
                ", audience_rating='" + audience_rating + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutrition_facts='" + nutrition_facts + '\'' +
                ", color='" + color + '\'' +
                ", format='" + format + '\'' +
                ", package_quantity='" + package_quantity + '\'' +
                ", size='" + size + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", release_date='" + release_date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

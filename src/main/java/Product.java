import java.util.Arrays;

public class Product {

    private int barcode_number;
    private String barcode_type, barcode_formats, mpn, model, asin, product_name, title, category,
            manufacturer, brand, label, author, publisher, artist, actor, director, studio, genre, audience_rating,
            ingredients, nutrition_facts, color, format, package_quantity, size, length, width, height, weight,
            release_date, description;
    private String[] features;
    private String[] images;
    private String[] stores;
    private String[] reviews;

    public int getBarcode() {
        return barcode_number;
    }

    public String getBarcodeType() {
        return barcode_type;
    }

    public String getBarcodeFormats() {
        return barcode_formats;
    }

    public String getMpn() {
        return mpn;
    }

    public String getModel() {
        return model;
    }

    public String getAsin() {
        return asin;
    }

    public String getProductName() {
        return product_name;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public String getLabel() {
        return label;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getArtist() {
        return artist;
    }

    public String getActor() {
        return actor;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public String getGenre() {
        return genre;
    }

    public String getAudienceRating() {
        return audience_rating;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getNutritionFacts() {
        return nutrition_facts;
    }

    public String getColor() {
        return color;
    }

    public String getFormat() {
        return format;
    }

    public String getPackageQuantity() {
        return package_quantity;
    }

    public String getSize() {
        return size;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public String getDescription() {
        return description;
    }

    public String[] getFeatures() {
        return features;
    }

    public String[] getImages() {
        return images;
    }

    public String[] getStores() {
        return stores;
    }

    public String[] getReviews() {
        return reviews;
    }

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
                ", features=" + Arrays.toString(features) +
                ", images=" + Arrays.toString(images) +
                ", stores=" + Arrays.toString(stores) +
                ", reviews=" + Arrays.toString(reviews) +
                '}';
    }
}

import java.util.Arrays;

public class Product {

    private String barcode_number, barcode_type, barcode_formats, mpn, model, asin, product_name, title, category,
            manufacturer, brand, label, author, publisher, artist, actor, director, studio, genre, audience_rating,
            ingredients, nutrition_facts, color, format, package_quantity, size, length, width, height, weight,
            release_date, description;
    private String[] features, images, reviews;
    private Stores stores;

    public String getBarcode() {
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

    public Stores getStores() {
        return stores;
    }

    public String[] getReviews() {
        return reviews;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (product_name != null && !product_name.isEmpty()) {
            stringBuilder.append("Product Name: " + product_name);
        }
        if (barcode_number != null && !barcode_number.isEmpty()) {
            stringBuilder.append("\nBarcode Number: " + barcode_number);
        }

        if (barcode_type != null && !barcode_type.isEmpty()) {
            stringBuilder.append("\nBarcode Type: " + barcode_type);
        }

        if (barcode_formats != null && !barcode_formats.isEmpty()) {
            stringBuilder.append("\nBarcode Formats: " + barcode_formats);
        }

        if (mpn != null && !mpn.isEmpty()) {
            stringBuilder.append( "\nMPN: " + mpn);
        }

        if (model != null && !model.isEmpty()) {
            stringBuilder.append("\nModel: " + model);
        }

        if (asin != null && !asin.isEmpty()) {
            stringBuilder.append("\nAmazon Standard Identification Number: " + asin);
        }

        if (title != null && !title.isEmpty()) {
            stringBuilder.append("\nTitle: " + title);
        }

        if (category != null && !category.isEmpty()) {
            stringBuilder.append("\nCategory: " + category);
        }

        if (manufacturer != null && !manufacturer.isEmpty()) {
            stringBuilder.append("\nManufacturer: " + manufacturer);
        }

        if (brand != null && !brand.isEmpty()) {
            stringBuilder.append("\nBrand: " + brand);
        }

        if (label != null && !label.isEmpty()) {
            stringBuilder.append("\nLabel: " + label);
        }

        if (author != null && !author.isEmpty()) {
            stringBuilder.append("\nAuthor: " + author);
        }

        if (publisher != null && !publisher.isEmpty()) {
            stringBuilder.append("\nPublisher: " + publisher);
        }

        if (artist != null && !artist.isEmpty()) {
            stringBuilder.append("\nArtist: " + artist);
        }

        if (actor != null && !actor.isEmpty()) {
            stringBuilder.append("\nActor: " + actor);
        }

        if (director != null && !director.isEmpty()) {
            stringBuilder.append("\nDirector: " + director);
        }

        if (studio != null && !studio.isEmpty()) {
            stringBuilder.append("\nStudio: " + studio);
        }

        if (genre != null && !genre.isEmpty()) {
            stringBuilder.append("\nGenre: " + genre);
        }

        if (audience_rating != null && !audience_rating.isEmpty()) {
            stringBuilder.append("\nAudience Rating: " + audience_rating);
        }

        if (ingredients != null && !ingredients.isEmpty()) {
            stringBuilder.append("\nIngredients: " + ingredients);
        }

        if (nutrition_facts != null && !nutrition_facts.isEmpty()) {
            stringBuilder.append("\nNutrition Facts: " + nutrition_facts);
        }

        if (color != null && !color.isEmpty()) {
            stringBuilder.append("\nColor: " + color);
        }

        if (format != null && !format.isEmpty()) {
            stringBuilder.append("\nFormat: " + format);
        }

        if (package_quantity != "") {
            stringBuilder.append("\nPackage Quantity: " + package_quantity);
        }

        if (size != null && !size.isEmpty()) {
            stringBuilder.append("\nSize: " + size);
        }

        if (length != null && !length.isEmpty()) {
            stringBuilder.append("\nLength: " + length);
        }

        if (width != null && !width.isEmpty()) {
            stringBuilder.append("\nWidth: " + width);
        }

        if (height != null && !height.isEmpty()) {
            stringBuilder.append("\nHeight: " + height);
        }

        if (weight != null && !weight.isEmpty()) {
            stringBuilder.append("\nWeight: " + weight);
        }

        if (release_date != null && !release_date.isEmpty()) {
            stringBuilder.append("\nRelease Date: " + release_date);
        }

        if (description != null && !description.isEmpty()) {
            stringBuilder.append("\n\nDescription: " + description);
        }

        if (features.length > 0) {
            stringBuilder.append("\n\nFeatures: " + Arrays.toString(features));
        }

        /*if (stores.size() > 0) {
            stringBuilder.append("\n\nStores: " + stores);
        }*/

        if (reviews.length > 0) {
            stringBuilder.append("\n\nReviews: " + Arrays.toString(reviews));
        }

        return stringBuilder.toString();
    }
}

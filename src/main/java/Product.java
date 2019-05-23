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
        StringBuilder stringBuilder = new StringBuilder("<html>");
        if (product_name != null && !product_name.isEmpty()) {
            stringBuilder.append("Product Name: " + product_name);
        }
        if (barcode_number != null && !barcode_number.isEmpty()) {
            stringBuilder.append("<br/>Barcode Number: " + barcode_number);
        }

        if (barcode_type != null && !barcode_type.isEmpty()) {
            stringBuilder.append("<br/>Barcode Type: " + barcode_type);
        }

        if (barcode_formats != null && !barcode_formats.isEmpty()) {
            stringBuilder.append("<br/>Barcode Formats: " + barcode_formats);
        }

        if (mpn != null && !mpn.isEmpty()) {
            stringBuilder.append( "<br/>MPN: " + mpn);
        }

        if (model != null && !model.isEmpty()) {
            stringBuilder.append("<br/>Model: " + model);
        }

        if (asin != null && !asin.isEmpty()) {
            stringBuilder.append("<br/>Amazon Standard Identification Number: " + asin);
        }

        if (title != null && !title.isEmpty()) {
            stringBuilder.append("<br/>Title: " + title);
        }

        if (category != null && !category.isEmpty()) {
            stringBuilder.append("<br/>Category: " + category);
        }

        if (manufacturer != null && !manufacturer.isEmpty()) {
            stringBuilder.append("<br/>Manufacturer: " + manufacturer);
        }

        if (brand != null && !brand.isEmpty()) {
            stringBuilder.append("<br/>Brand: " + brand);
        }

        if (label != null && !label.isEmpty()) {
            stringBuilder.append("<br/>Label: " + label);
        }

        if (author != null && !author.isEmpty()) {
            stringBuilder.append("<br/>Author: " + author);
        }

        if (publisher != null && !publisher.isEmpty()) {
            stringBuilder.append("<br/>Publisher: " + publisher);
        }

        if (artist != null && !artist.isEmpty()) {
            stringBuilder.append("<br/>Artist: " + artist);
        }

        if (actor != null && !actor.isEmpty()) {
            stringBuilder.append("<br/>Actor: " + actor);
        }

        if (director != null && !director.isEmpty()) {
            stringBuilder.append("<br/>Director: " + director);
        }

        if (studio != null && !studio.isEmpty()) {
            stringBuilder.append("<br/>Studio: " + studio);
        }

        if (genre != null && !genre.isEmpty()) {
            stringBuilder.append("<br/>Genre: " + genre);
        }

        if (audience_rating != null && !audience_rating.isEmpty()) {
            stringBuilder.append("<br/>Audience Rating: " + audience_rating);
        }

        if (ingredients != null && !ingredients.isEmpty()) {
            stringBuilder.append("<br/>Ingredients: " + ingredients);
        }

        if (nutrition_facts != null && !nutrition_facts.isEmpty()) {
            stringBuilder.append("<br/>Nutrition Facts: " + nutrition_facts);
        }

        if (color != null && !color.isEmpty()) {
            stringBuilder.append("<br/>Color: " + color);
        }

        if (format != null && !format.isEmpty()) {
            stringBuilder.append("<br/>Format: " + format);
        }

        if (package_quantity != "") {
            stringBuilder.append("<br/>Package Quantity: " + package_quantity);
        }

        if (size != null && !size.isEmpty()) {
            stringBuilder.append("<br/>Size: " + size);
        }

        if (length != null && !length.isEmpty()) {
            stringBuilder.append("<br/>Length: " + length);
        }

        if (width != null && !width.isEmpty()) {
            stringBuilder.append("<br/>Width: " + width);
        }

        if (height != null && !height.isEmpty()) {
            stringBuilder.append("<br/>Height: " + height);
        }

        if (weight != null && !weight.isEmpty()) {
            stringBuilder.append("<br/>Weight: " + weight);
        }

        if (release_date != null && !release_date.isEmpty()) {
            stringBuilder.append("<br/>Release Date: " + release_date);
        }

        if (description != null && !description.isEmpty()) {
            stringBuilder.append("<br/>Description: " + description);
        }

        if (features.length > 0) {
            stringBuilder.append("<br/>Features: " + Arrays.toString(features));
        }

        if (stores != null) {
            stringBuilder.append("<br/>Stores: " + stores);
        }

        if (reviews.length > 0) {
            stringBuilder.append("<br/>Reviews: " + Arrays.toString(reviews));
        }

        stringBuilder.append("<html");
        return stringBuilder.toString();
    }
}

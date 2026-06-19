package org.skypro.model.Product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.model.Search.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Error");
        }
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Error");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @JsonIgnore
    @Override
    public String getSearchTerms() {
        return productName;
    }

    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }
}

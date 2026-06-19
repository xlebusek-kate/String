package org.skypro.model.Product;


import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;
    private final UUID id;
    public SimpleProduct(String productName, int price , UUID id) {
        super(productName);
        if (price <= 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.price = price;
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice();
    }

    @Override
    public UUID getId() {
        return id;
    }

}

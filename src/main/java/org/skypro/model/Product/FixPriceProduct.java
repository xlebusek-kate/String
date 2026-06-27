package org.skypro.model.Product;

import org.skypro.model.Product.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;
    private final UUID id;

    public FixPriceProduct(String productName , UUID id) {
        super(productName);
        this.id = id;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + " с фиксированной ценой: " + getPrice();
    }

    @Override
    public UUID getId() {
        return id;
    }
}

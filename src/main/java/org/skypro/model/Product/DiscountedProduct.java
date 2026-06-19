package org.skypro.model.Product;

import org.skypro.model.Product.Product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discountedPrice;
    private final UUID id;

    public DiscountedProduct(String productName, double basePrice, int discountedPrice,UUID id) {
        super(productName);
        this.id = id;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        if (discountedPrice < 0) {
            throw new IllegalArgumentException("discounted price cannot be negative");
        }
        if (discountedPrice > 100) {
            throw new IllegalArgumentException("incorrect discounted price cannot be greater than 100");
        }
        this.basePrice = basePrice;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - discountedPrice / 100.0));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s со скидкой: %.2f (%d%%)", getProductName(), getPrice(), discountedPrice);
    }

    @Override
    public UUID getId() {
        return id;
    }
}


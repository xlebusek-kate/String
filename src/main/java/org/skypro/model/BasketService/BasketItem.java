package org.skypro.model.BasketService;

import org.skypro.model.Product.Product;

public class BasketItem {
    private final Product product;
    private final int quantity;

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public Integer getQuantity(){
        return this.quantity;
    }




}

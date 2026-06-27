package org.skypro.model;

import org.skypro.model.Basket.ProductBasket;
import org.skypro.model.Product.Product;
import org.skypro.model.Service.StorageService;
import org.springframework.stereotype.Service;

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

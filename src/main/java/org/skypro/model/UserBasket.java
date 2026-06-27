package org.skypro.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserBasket {
    private final List<BasketItem> basketWithTotal;
    private final double total;

    public UserBasket(List<BasketItem> basketWithTotal) {
        this.basketWithTotal = List.copyOf(basketWithTotal);
        this.total = basketWithTotal.stream()
                .mapToDouble(basket -> basket.getProduct().getPrice() * basket.getQuantity() )
                .sum();
    }

    public List<BasketItem> getBasketWithTotal() {
        return basketWithTotal;
    }

    public double getTotal() {
        return total;
    }
}




package org.skypro.model.BasketService;

import java.util.List;


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




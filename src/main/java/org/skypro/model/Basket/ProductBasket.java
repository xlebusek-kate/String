package org.skypro.model.Basket;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {

    private final Map<UUID, Integer> basket = new HashMap<>();

    public void addProduct(UUID uuid) {
        basket.computeIfAbsent(uuid, id -> 0);
        basket.compute(uuid, (id, count) -> count + 1);
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

}

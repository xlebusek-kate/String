package org.skypro.model;

import org.skypro.model.Basket.ProductBasket;
import org.skypro.model.Product.Product;
import org.skypro.model.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addById(UUID uuid) {
        if (storageService.getProductByID(uuid).isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            productBasket.addProduct(uuid);
        }
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getBasket();
        List<BasketItem> items = new ArrayList<>();
        for (Map.Entry<UUID, Integer> entry : basketMap.entrySet()) {
            UUID productId = entry.getKey();
            int quantity = entry.getValue();
            Optional<Product> productOpt = storageService.getProductByID(productId);

            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                BasketItem item = new BasketItem(product, quantity);
                items.add(item);
            }
        }
        UserBasket userBasket = new UserBasket(items);
        return userBasket;
    }
}

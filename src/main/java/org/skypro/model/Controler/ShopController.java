package org.skypro.model.Controler;

import org.skypro.model.Article.Article;
import org.skypro.model.Basket.ProductBasket;
import org.skypro.model.BasketItem;
import org.skypro.model.BasketService;
import org.skypro.model.Product.Product;
import org.skypro.model.Service.SearchResult;
import org.skypro.model.Service.SearchService;
import org.skypro.model.Service.StorageService;
import org.skypro.model.UserBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;
    private final ProductBasket productBasket;
    private final BasketService basketService;

    @Autowired
    public ShopController(SearchService searchService, StorageService storageService, ProductBasket productBasket, BasketService basketService) {
        this.searchService = searchService;
        this.storageService = storageService;
        this.productBasket = productBasket;
        this.basketService = basketService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getMapOfProduct();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getMapOfArticle();
    }

    @GetMapping("/search")
    Collection<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        storageService.getProductByID(id).orElseThrow(() -> new IllegalArgumentException("Ошибка"));
        productBasket.addProduct(id);
        return "Продукт c id = " + id + " был добавлен" ;
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
         return basketService.getUserBasket();
    }

}

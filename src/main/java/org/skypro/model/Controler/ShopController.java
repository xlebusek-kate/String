package org.skypro.model.Controler;

import org.skypro.model.Article.Article;
import org.skypro.model.Product.Product;
import org.skypro.model.Service.SearchResult;
import org.skypro.model.Service.SearchService;
import org.skypro.model.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;

    @Autowired
    public ShopController(SearchService searchService, StorageService storageService) {
        this.searchService = searchService;
        this.storageService = storageService;
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
}

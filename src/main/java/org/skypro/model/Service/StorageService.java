package org.skypro.model.Service;

import org.skypro.model.Article.Article;
import org.skypro.model.Product.FixPriceProduct;
import org.skypro.model.Product.Product;
import org.skypro.model.Product.SimpleProduct;
import org.skypro.model.Search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> mapOfProduct;
    private final Map<UUID, Article> mapOfArticle;

    public StorageService() {
        this.mapOfArticle = new HashMap<>();
        this.mapOfProduct = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        mapOfProduct.put(uuid, new FixPriceProduct("Самолет", UUID.randomUUID()));
        mapOfArticle.put(UUID.randomUUID(), new Article("Книга", "Война и мир", UUID.randomUUID()));
        mapOfProduct.put(UUID.randomUUID(), new SimpleProduct("Машинка", 1200 , UUID.randomUUID()));
        System.out.println("Самолет" + uuid);
    }

    public Collection<Article> getMapOfArticle() {
        return mapOfArticle.values();
    }

    public Collection<Product> getMapOfProduct() {
        return mapOfProduct.values();
    }

    public Collection<Searchable> searchInStorageService() {
        Collection<Searchable> collectionOfSearchable = new ArrayList<>();
        for (UUID keys : mapOfArticle.keySet()){
        collectionOfSearchable.add(mapOfArticle.get(keys));
        }
        for (UUID keys : mapOfProduct.keySet()){
            collectionOfSearchable.add(mapOfProduct.get(keys));
        }
        return collectionOfSearchable;
    }

    public Optional<Product> getProductByID(UUID uuid){
        return Optional.ofNullable(mapOfProduct.get(uuid));
    }
}

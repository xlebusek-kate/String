import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.model.Article.Article;
import org.skypro.model.Basket.ProductBasket;
import org.skypro.model.BasketService.BasketService;
import org.skypro.model.BasketService.UserBasket;
import org.skypro.model.Product.FixPriceProduct;
import org.skypro.model.Product.Product;
import org.skypro.model.Product.SimpleProduct;
import org.skypro.model.Service.StorageService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.useRepresentation;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class StorageServiceTest {
    @Mock
    ProductBasket productBasket;

    @Mock
    StorageService storageService;

    @InjectMocks
    BasketService basketService;
    @Test
    public void addNonexistentProduct_throwException() {
        UUID uuid = UUID.randomUUID();
        when(storageService.getProductByID(uuid)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> productBasket.addProduct(uuid));
    }

    @Test
    public void addExistingProduct() {
        UUID uuid = UUID.randomUUID();
        Product product = new SimpleProduct("Банан", 100, uuid);
        when(storageService.getProductByID(uuid)).thenReturn(Optional.of(product));
        productBasket.addProduct(uuid);
        verify(productBasket, times(1)).addProduct(uuid);
    }

    @Test
    public void getUserBasketReturnNull() {
        when(productBasket.getBasket()).thenReturn(Collections.emptyMap());
        BasketService basketService = new BasketService(productBasket, null);
        assertThat(basketService.getUserBasket().getBasketWithTotal()).isEmpty();
        assertThat(basketService.getUserBasket().getTotal()).isZero();
    }

    @Test
    public void getUserBasketReturnNotNull(){
        Map<UUID , Integer> productBasket1 =new HashMap<>();
        UUID uuid = UUID.randomUUID();
        productBasket1.put(uuid, 7);
        when(productBasket.getBasket()).thenReturn(productBasket1);
        Product product = new SimpleProduct("Car", 700, uuid);
        when(storageService.getProductByID(uuid)).thenReturn(Optional.of(product));
        UserBasket userBasket = basketService.getUserBasket();
        assertThat(userBasket.getBasketWithTotal().size()).isEqualTo(productBasket1.size());
        assertThat(userBasket.getTotal()).isEqualTo(product.getPrice()* productBasket1.get(uuid));



    }
}



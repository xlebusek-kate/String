import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.model.Product.FixPriceProduct;
import org.skypro.model.Product.SimpleProduct;
import org.skypro.model.Search.Searchable;
import org.skypro.model.Service.SearchResult;
import org.skypro.model.Service.SearchService;
import org.skypro.model.Service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SearchServiceTest.class);
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    public void testSearchInStorageService_whenStorageServiceIsEmpty() {
        when(storageService.getCollectionAllProducts()).thenReturn(Collections.emptyList());
        Collection<SearchResult> results = searchService.search("Что то");
        assertThat(results).isEmpty();
    }

    @Test
    public void testSearchInStorageService_whenStorageServiceHasInappropriateValues() {
        Collection<Searchable> products = new ArrayList<>();
        products.add(new SimpleProduct("NameOfProduct1", 100, UUID.randomUUID()));
        products.add(new FixPriceProduct("NameOfProduct2", UUID.randomUUID()));
        when(storageService.getCollectionAllProducts()).thenReturn(products);
        Collection<SearchResult> results = searchService.search("NameOfProduct3");
        assertThat(results).isEmpty();
    }

    @Test
    public void testSearchInStorageService_whenStorageServiceHasSuitableValues() {
        Collection<Searchable> products = new ArrayList<>();
        products.add(new SimpleProduct("NameOfProduct1", 100, UUID.randomUUID()));
        products.add(new FixPriceProduct("TestProduct", UUID.randomUUID()));
        when(storageService.getCollectionAllProducts()).thenReturn(products);
        Collection<SearchResult> result = searchService.search("Test");
        assertThat(result).hasSize(1);
        assertThat(result.iterator().next().getName()).isEqualTo("TestProduct");
    }
}

package org.skypro.model.Service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search (String pattern){
        return storageService.searchInStorageService().stream().filter(item -> item.getSearchTerms().contains(pattern))
                .map(SearchResult :: fromSearchable)
                .collect(Collectors.toList());
    }
}

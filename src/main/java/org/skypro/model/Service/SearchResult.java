package org.skypro.model.Service;

import org.skypro.model.Search.Searchable;

import java.util.UUID;

public class SearchResult {
    public final UUID id;
    public final String name;
    public final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }
    public static SearchResult fromSearchable (Searchable searchable){
        return new SearchResult(searchable.getId(), searchable.getSearchTerms(),searchable.getContentType());
    }
}

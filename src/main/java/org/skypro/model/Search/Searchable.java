package org.skypro.model.Search;

import java.util.UUID;

public interface Searchable {

    String getSearchTerms();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerms() + " - " + getContentType();
    }
    UUID getId();
}

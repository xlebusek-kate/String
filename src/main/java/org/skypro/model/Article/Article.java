package org.skypro.model.Article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.model.Search.Searchable;

import java.util.UUID;

public class Article implements Searchable {

    private final String articleTitle;
    private final String text;
    private final UUID id;

    public Article(String articleTitle, String text, UUID id) {
        this.articleTitle = articleTitle;
        this.text = text;
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

@JsonIgnore
    @Override
    public String getSearchTerms() {
        return toString();
    }
@JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return "Название статьи " + articleTitle + '\'' +
                " Текст статьи: " + text + '\'';
    }
}
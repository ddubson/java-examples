package com.ddubson.patterns.memento;

/**
 * Created by ddubson on 12/25/14.
 */
public class Memento {
    private String article;

    public Memento(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }
}

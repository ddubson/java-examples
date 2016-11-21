package com.ddubson.patterns.memento;

/**
 * Created by ddubson on 12/25/14.
 */
public class Originator {
    private String article;

    public void setArticle(String newArticle) {
        System.out.println("From Originator: Current Version of Article\n"+newArticle+ "\n");
        this.article = newArticle;
    }

    public Memento storeInMemento() {
        System.out.println("From Originator: Saving to Memento");
        return new Memento(article);
    }

    public String restoreFromMemento(Memento memento) {
        article = memento.getArticle();
        System.out.println("From Originator: Previous Article Saved in Memento\n"+article + "\n");
        return article;

    }
}

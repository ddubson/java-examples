package com.ddubson.patterns.memento;

import java.util.ArrayList;

/**
 * Created by ddubson on 12/25/14.
 */
public class Caretaker {
    // Where all mementos are saved
    ArrayList<Memento> savedArticles = new ArrayList<Memento>();

    // Adds memento to the ArrayList

    public void addMemento(Memento m) {
        savedArticles.add(m);
    }

    // Gets the memento requested from the ArrayList

    public Memento getMemento(int index) {
        return savedArticles.get(index);
    }
}

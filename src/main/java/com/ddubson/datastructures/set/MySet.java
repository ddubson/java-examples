package com.ddubson.datastructures.set;

import java.util.Iterator;

/**
 * Author: ddubson
 */
public interface MySet {
    void add(Object i);

    boolean contains(Object i);

    int size();

    boolean isEmpty();

    void clear();

    void remove(Object i);

    Iterator iterator();
}

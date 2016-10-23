package com.ddubson.datastructures.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Author: ddubson
 */
public class MySetImpl implements MySet {
    Object[] arr;
    int size;

    public MySetImpl() {
        this.arr = new Object[1000];
    }

    private int hashFunction(Object obj) {
        return obj.hashCode() % this.arr.length;
    }

    @Override
    public void add(Object i) {
        int index = hashFunction(i);

        if(arr[index] != null) {
            throw new IllegalStateException();
        } else {
            arr[index] = i;
            size++;
        }
    }

    @Override
    public boolean contains(Object i) {
        return this.arr[hashFunction(i)] != null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        Arrays.fill(arr, null);
        size = 0;
    }

    @Override
    public void remove(Object i) {
        this.arr[hashFunction(i)] = null;
        size--;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this.arr);
    }

    private class ArrayIterator implements Iterator {
        private Object[] arr;
        int curIndex;
        public ArrayIterator(Object[] arr) {
            this.arr = arr;
            this.curIndex = -1;

            this.arr = Arrays.stream(arr).filter(object -> object != null).toArray();
        }

        @Override
        public boolean hasNext() {
            return curIndex+1 < arr.length;
        }

        @Override
        public Object next() {
            return arr[++curIndex];
        }
    }
}

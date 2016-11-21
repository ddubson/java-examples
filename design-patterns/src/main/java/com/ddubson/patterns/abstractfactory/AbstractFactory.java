package com.ddubson.patterns.abstractfactory;

public abstract class AbstractFactory<T> {
    abstract T get(String type);
}

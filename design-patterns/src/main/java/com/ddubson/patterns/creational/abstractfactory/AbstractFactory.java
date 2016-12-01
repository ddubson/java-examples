package com.ddubson.patterns.creational.abstractfactory;

public abstract class AbstractFactory<T> {
    abstract T get(String type);
}

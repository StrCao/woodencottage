package com.xicheng.javase.generics.erase;

import java.util.ArrayList;
import java.util.List;

public class GenericClass01<T> {

    private List<T> list = new ArrayList<>();

    public static GenericClass01 genericClass01 = new GenericClass01();

    private GenericClass01() {
    }

    public static GenericClass01 getInstance() {
        return genericClass01;
    }

    public void add(T t) {
        list.add(t);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

package com.xicheng.javase.generics.erase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericErase {

    @Test
    public void test01() throws Exception {
        GenericClass01<String> genericClass01 = GenericClass01.getInstance();
        genericClass01.add("test01");
        Class<? extends GenericClass01> aClass = genericClass01.getClass();
        GenericClass01 genericClass011 = aClass.newInstance();
        genericClass011.add(1);
        System.out.println(genericClass01.getList());
    }

    @Test
    public void test02() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class<? extends List> c1 = stringList.getClass();
        Class<? extends List> c2 = integerList.getClass();
        System.out.println(c1 == c2);
    }
}

package com.xicheng.datastructure.hashmap;

import org.junit.Before;
import org.junit.Test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
public class HashMapController {

    private static HashMap<String, String> hashMap = new HashMap<>();
    private static Hashtable<String, String> hashtable = new Hashtable<>();
    @Before
    public void before() {
        hashMap.put("hashMap01", "hashMap01");
        hashMap.put("hashMap02", "hashMap02");
        hashMap.put("hashMap03", "hashMap03");

        hashtable.put("hashTable01", "hashTable01");
        hashtable.put("hashTable02", "hashTable02");
        hashtable.put("hashTable03", "hashTable03");
    }

    public void test01() {
        HashMap hashMap = new HashMap();
    }

    /**
     * 测试Hashmap的failfast机制
     */
    @Test
    public void test02() {
        Iterator<String> iterator = hashMap.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            hashMap.remove("hashMap02");
        }
    }

    @Test
    public void test03() {
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }

    /**
     * hashtable的遍历没有failfast机制
     */
    @Test
    public void test04() {
        Enumeration<String> elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
            hashtable.remove("hashTable02");
        }
    }

}

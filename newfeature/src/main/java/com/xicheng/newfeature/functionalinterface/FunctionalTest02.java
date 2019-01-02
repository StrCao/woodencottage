package com.xicheng.newfeature.functionalinterface;

import com.xicheng.newfeature.common.Person;
import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/29
 */
public class FunctionalTest02 {

    @Test
    public void test01() {
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("Hello", "World");
        System.out.println(person);
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

}

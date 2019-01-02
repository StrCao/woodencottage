package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.common.Person;
import com.xicheng.newfeature.util.PrintUtil;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author xichengxml
 * @date 2019/1/2
 */
public class ConsumersController {

    @Test
    public void test01() {
        Consumer<Person> consumer = (p) -> PrintUtil.print(p.getFirstName(), p.getLastName());
        consumer.accept(new Person("Bryan", "Liu"));
        consumer.accept(new Person("Cathy", "Zhang"));
    }

}

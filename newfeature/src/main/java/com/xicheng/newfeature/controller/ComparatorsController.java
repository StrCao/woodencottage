package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.common.Person;
import com.xicheng.newfeature.util.PrintUtil;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author xichengxml
 * @date 2019/1/2
 */
public class ComparatorsController {

    @Test
    public void test01() {
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person person01 = new Person("Bryan", "Liu");
        Person person02 = new Person("Cathy", "Zhang");
        int result01 = comparator.compare(person01, person02);
        int result02 = comparator.reversed().compare(person01, person02);
        PrintUtil.print(result01, result02);
    }
}

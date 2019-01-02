package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.common.Person;
import com.xicheng.newfeature.util.PrintUtil;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */
public class SuppliersController {

    @Test
    public void test01() {
        Supplier<Person> supplier = Person::new;
        Person person01 = supplier.get();
        Person person02 = supplier.get();
        PrintUtil.print(person01, person02);
    }

}

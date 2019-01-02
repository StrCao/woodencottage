package com.xicheng.newfeature.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */
public class Person {

    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

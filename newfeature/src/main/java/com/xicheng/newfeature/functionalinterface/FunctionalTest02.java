package com.xicheng.newfeature.functionalinterface;

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

    class Person {
        private String firstName;
        private String lastName;

        private Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Person() {
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
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
}

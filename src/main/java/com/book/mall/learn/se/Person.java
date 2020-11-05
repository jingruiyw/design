package com.book.mall.learn.se;

import org.springframework.security.core.parameters.P;

/**
 * ClassName: Person
 * Description:
 * date: 2020/11/1 5:43 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Person extends Animal {

    public Person() {
        super();
        System.out.println("mmm");
    }

    @Override
    public void saySomething(String content, Integer times) {
        super.saySomething(content, times);
    }

    public String a(String content) {
        System.out.println("aaa");
        return "aa";
    }

    public void a(String content, Integer age) {
        System.out.println("aaa");
    }


    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal person = new Person();

        Person p1 = new Person();
        Animal a1 = p1;
        Person p2 = (Person) a1;


//        Cat c1 = (Cat) new Animal();

        System.out.println(a1 instanceof Cat);

        System.out.println(person);
    }
}

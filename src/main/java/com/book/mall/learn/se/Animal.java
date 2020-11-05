package com.book.mall.learn.se;

import lombok.Data;

/**
 * ClassName: Animal
 * Description:
 * date: 2020/11/1 5:41 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
@Data
public class Animal {

    public Animal() {
        System.out.println("animal");
    }

    private String name;
    private Integer age;

    public void saySomething(String content, Integer times) {
        for (int i = 0; i < times; i++) {
            System.out.println("第" + i + "次say: " + content);
        }
    }
}

package com.book.mall.learn.test;

/**
 * ClassName: StringTest
 * Description:
 * date: 2020/4/27 12:54 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class StringTest {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("asdfg");
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}

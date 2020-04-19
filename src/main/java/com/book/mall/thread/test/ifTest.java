package com.book.mall.thread.test;

/**
 * ClassName: ifTest
 * Description:
 * date: 2020/4/14 6:05 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ifTest {

    public static void main(String[] args) {

        String str = "a";
        String str2 = "b";

        method(str);
    }

    private static void method (String msg) {
        if (!msg.equals("a") && !msg.equals("b")) {
            System.out.println("====>");
        }
    }
}

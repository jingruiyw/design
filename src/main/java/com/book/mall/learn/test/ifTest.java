package com.book.mall.learn.test;

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


        System.out.println(String.format("%02d分钟%02d秒", 100 / 60, 100 % 60));

    }

    private static void method (String msg) {
        if (!msg.equals("a") && !msg.equals("b")) {
            System.out.println("====>");
        }
    }
}

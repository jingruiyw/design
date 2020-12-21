package com.book.mall.test;

/**
 * ClassName: Test
 * Description:
 * date: 2020/12/19 11:41 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Test {


    public static void main(String[] args) {
        String str = "验证码是：{code}, 机器人将等待您 {time} 分钟";
        String str1 = "验证码是, 机器人将等待您 {time} 分钟";

        System.out.println(str.replace("{code}", "1234").replace("{time}", "3"));
        System.out.println(str1.replace("{code}", "1234").replace("{time}", "3"));
    }

}

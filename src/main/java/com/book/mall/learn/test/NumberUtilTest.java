package com.book.mall.learn.test;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * ClassName: NumberUtilTest
 * Description:
 * date: 2020/4/17 4:33 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class NumberUtilTest {

    public static void main(String[] args) {
        Integer num = 1;
        Integer num2 = 1;
        int compare = NumberUtils.compare(num, num2);
        System.out.println(compare);
    }
}

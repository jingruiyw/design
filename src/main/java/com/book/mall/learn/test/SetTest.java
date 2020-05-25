package com.book.mall.learn.test;

import java.util.*;

/**
 * ClassName: SetTest
 * Description:
 * date: 2020/5/9 2:08 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class SetTest {

    public static void main(String[] args) {
        List<Integer> total = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(4);
        one.add(9);
        one.add(9);
        List<Integer> two = new ArrayList<>();
        two.add(8);

        total.addAll(one);
        total.addAll(two);

        Collections.sort(total, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }

                return -1;
            }
        });
        System.out.println(total);


    }
}

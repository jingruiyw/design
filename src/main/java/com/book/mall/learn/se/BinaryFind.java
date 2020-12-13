package com.book.mall.learn.se;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinaryFind
 * Description:
 * date: 2020/12/11 11:46 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinaryFind {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println(findNum(-1, list));
        System.out.println(findNum(1, list));
//        System.out.println(findNum(2, list));
//        System.out.println(findNum(4, list));
//        System.out.println(findNum(6, list));
    }

    static int findNum(int target, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int mid = (start + end) / 2;
        if (target < list.get(start) || target > list.get(end)) return -1;
        while (start <= end) {
            if (target == list.get(mid)) {
                return mid;
            } else if (target < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}

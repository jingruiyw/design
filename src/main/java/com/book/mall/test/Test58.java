package com.book.mall.test;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Test58
 * Description:
 * date: 2021/6/15 6:30 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Test58 {

    public static Long convert(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("error !");
        }
        if (str.equals("-0")) {
            return 0L;
        }
        Set<Character> nums = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            nums.add((char) i);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (i != 0) {
                    throw new Exception("error !");
                }
                continue;
            }
            if (!nums.contains(str.charAt(i))) {
                throw new Exception("error !");
            }
        }
        return Long.valueOf(str);
    }
}

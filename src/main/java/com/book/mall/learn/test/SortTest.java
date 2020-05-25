package com.book.mall.learn.test;

import com.book.mall.learn.util.PinyinUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: SortTest
 * Description: 按照自然语言顺序排序
 * date: 2020/4/14 1:34 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */

public class SortTest {

    private static final Pattern BeginWithNum = Pattern.compile("^[0-9]+.*");
    private static final Pattern BeginWithLetter = Pattern.compile("^[a-zA-Z]+.*");

    public static void main(String[] args) {
        List<String> subareas = new ArrayList<>();
        subareas.add("把");
        subareas.add("阿萨");
        subareas.add("mjy");
        subareas.add("123");
        subareas.add("mm");
        subareas.add("￥%");
        List<String> list = sortSubareas(subareas);
        System.out.println(list);
    }

    /**
     * 排序楼座
     *
     * @param subareas
     * @return
     */
    private static List<String> sortSubareas(List<String> subareas) {
        //只有一个直接返回
        if (subareas == null || subareas.size() == 0 || subareas.size() == 1) {
            return subareas;
        }

        //有多个值时
        //字母开头/汉字开头
        Set<String> letters = new TreeSet<>(((o1, o2) -> {

            String lowerO1 = PinyinUtil.converterToFirstSpell(o1).toLowerCase();
            String lowerO2 = PinyinUtil.converterToFirstSpell(o2).toLowerCase();
            //都以数字开头, 比较
            if (matchPattern(lowerO1, BeginWithNum) && matchPattern(lowerO1, BeginWithNum)) {
                if (lowerO1.charAt(0) > lowerO2.charAt(0)) {
                    return 1;
                } else {
                    return -1;
                }
            }

            //都以字母开头，比较
            if (matchPattern(lowerO1, BeginWithLetter) && matchPattern(lowerO1, BeginWithLetter)) {
                if (lowerO1.charAt(0) > lowerO2.charAt(0)) {
                    return 1;
                } else {
                    return -1;
                }
            }

            //一个数字一个字母，字母排前面
            if (matchPattern(lowerO1, BeginWithNum) && matchPattern(lowerO1, BeginWithLetter)) {
                return -1;
            } else if (matchPattern(lowerO1, BeginWithLetter) && matchPattern(lowerO1, BeginWithNum)){
                return 1;
            }

            //数字、字母在特殊符号前
            if (matchPattern(lowerO1, BeginWithNum) || matchPattern(lowerO1, BeginWithLetter)) {
                return 1;
            }
            return -1;
        }));

//        letters.addAll(subareas);
        for (String subarea : subareas) {
            letters.add(subarea);
        }
        return new ArrayList<>(letters);
    }


    public static int atoi(String str) {
        //这里要小心，需要判断有效性
        if (str == null || str.length() == 0) {
            return 0;
        }
        int nlen = str.length();
        double sum = 0;
        int sign = 1;
        int j = 0;
        //剔除空格
        while (str.charAt(j) == ' ') {
            j++;
        }
        //判断正数和负数
        if (str.charAt(j) == '+') {
            sign = 1;
            j++;
        } else if (str.charAt(j) == '-') {
            sign = -1;
            j++;
        }

        for (int i = j; i < nlen; i++) {
            char current = str.charAt(i);
            if (current >= '0' && current <= '9') {
                sum = sum * 10 + (int) (current - '0');
            } else {
                break;//碰到非数字，退出转换
            }
        }
        sum = sum * sign;
        //这里要小心，需要判断范围
        if (sum > Integer.MAX_VALUE) {
            sum = Integer.MAX_VALUE;
        } else if (sum < Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return (int) sum;
    }

    /**
     * 按照自然语言顺序排序
     *
     * @param list
     */
    public static void naturalSort(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
            int i = 0, j = 0;
            String temp1, temp2;
            int num1, num2;
            int length = Math.min(o1.length(), o2.length());
            while (i < length && j < length) {
                temp1 = "";
                temp2 = "";
                if (o1.charAt(i) > '9' || o1.charAt(i) < '0' || o2.charAt(j) > '9' || o2.charAt(j) < '0') {
                    if (o1.charAt(i) == o2.charAt(j)) {
                        i++;
                        j++;
                        continue;
                    } else if (o1.charAt(i) > o2.charAt(j)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                while (i < o1.length() && o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                    temp1 += o1.charAt(i);
                    i++;
                }
                while (j < o2.length() && o2.charAt(j) <= '9' && o2.charAt(j) >= '0') {
                    temp2 += o2.charAt(j);
                    j++;
                }
                num1 = atoi(temp1);
                num2 = atoi(temp2);
                if (num1 == num2) {
                    if (temp1.length() < temp2.length()) {
                        return 1;
                    } else if (temp1.length() > temp2.length()) {
                        return -1;
                    } else {
                        continue;
                    }
                } else if (num1 > num2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return o1.length() > o2.length() ? 1 : -1;
        });
    }

    /**
     * 正则匹配
     *
     * @param str
     * @param pattern
     * @return
     */
    private static boolean matchPattern(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}

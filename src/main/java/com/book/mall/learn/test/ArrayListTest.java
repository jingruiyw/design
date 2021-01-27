package com.book.mall.learn.test;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ArrayListTest
 * Description:
 * date: 2020/4/13 11:59 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ArrayListTest {

    private static final Pattern PATTERN = Pattern.compile("^[0-9]+.*");
    private static final Pattern ABC = Pattern.compile("^[a-zA-Z]+.*");


    public static void main(String[] args) {
//        List<String> list = Arrays.asList("中1", "中b", "5b", "71", "70", "a2", "a1");
//        List<String> list = Arrays.asList("啊天", "A1", "b", "吧呀", "C", "无", "Z", "2", "**", "1");
        List<String> list = Arrays.asList();

        List<String> result = sortSubareas(list);
        System.out.println(result);
        System.out.println();


    }

    /**
     * 电话本排序
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
            String lowerO1 = PinyinHelper.converterToFirstSpell(o1).toLowerCase();
            String lowerO2 = PinyinHelper.converterToFirstSpell(o2).toLowerCase();
            if (lowerO1.charAt(0) > lowerO2.charAt(0)) {
                return 1;
            } else {
                return -1;
            }
        }));

        //数字开头
        Set<String> nums = new TreeSet<>(((o1, o2) -> {
            if (o1.charAt(0) > o2.charAt(0)) {
                return 1;
            } else {
                return -1;
            }
        }));

        //其他特殊字符
        Set<String> others = new HashSet<>();
        for (String subarea : subareas) {
            //以数字开头放入另一个集合中
            //将汉字转成拼音
            String sub = PinyinHelper.converterToFirstSpell(subarea);
            if (match(sub, ABC)) {
                letters.add(subarea);
            } else if (match(sub, PATTERN)) {
                nums.add(subarea);
            } else {
                others.add(subarea);
            }
        }

        List<String> sortSubareas = new ArrayList<>(letters);
        sortSubareas.addAll(nums);
        sortSubareas.addAll(others);
        return sortSubareas;
    }

    /**
     * 第一版排序
     *
     * @param list
     * @return
     */
    private static List<String> sortList(List<String> list) {

        if (list == null || list.size() == 0 || list.size() == 1) {
            return list;
        }

        Set<String> s1 = new TreeSet<>(((o1, o2) -> {
            if (o1.charAt(0) > o2.charAt(0)) {
                return 1;
            } else {
                return -1;
            }
        }));

        Set<String> s2 = new TreeSet<>(((o1, o2) -> {
            String lowerO1 = o1.toLowerCase();
            String lowerO2 = o2.toLowerCase();
            if (lowerO1.charAt(0) > lowerO2.charAt(0)) {
                return 1;
            } else {
                return -1;
            }
        }));

        Set<String> s3 = new TreeSet<>(((o1, o2) -> {
            if (o1.charAt(0) > o2.charAt(0)) {
                return 1;
            } else {
                return -1;
            }
        }));


        for (String str : list) {
            //以数字开头放入另一个集合中
            if (match(str, PATTERN)) {
                s1.add(str);
            } else if (match(str, ABC)) {
                s2.add(str);
            } else {
                s3.add(str);
            }
        }

        System.out.println(s1); //数字
        System.out.println(s2); //字母
        System.out.println(s3); //特殊字符

        List<String> a = new ArrayList<>(s2);
        a.addAll(s1);
        a.addAll(s3);

        return a;
    }

    /**
     * 匹配器
     *
     * @param str
     * @param pattern
     * @return
     */
    private static boolean match(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}

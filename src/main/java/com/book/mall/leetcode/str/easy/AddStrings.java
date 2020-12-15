package com.book.mall.leetcode.str.easy;

/**
 * ClassName: AddStrings
 * Description:
 * 415. 字符串相加
 * date: 2020/12/15 10:50 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("9", "9"));
    }

    /**
     * 双指针，需要注意循环终止的条件，size1，size2，addOne有一个满足条件则进循环
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int size1 = num1.length() - 1;
        int size2 = num2.length() - 1;
        int addOne = 0;
        StringBuilder sb = new StringBuilder();
        //循环终止的条件是三个值有一个满足则进循环
        while (size1 >= 0 || size2 >= 0 || addOne != 0) {
            int s1;
            int s2;
            if (size1 >= 0) {
                //位数符合
                s1 = num1.charAt(size1) - '0';
            } else {
                //位数不符合
                s1 = 0;
            }
            if (size2 >= 0) {
                //位数符合
                s2 = num2.charAt(size2) - '0';
            } else {
                //位数不符合
                s2 = 0;
            }
            sb.append((addOne + s1 + s2) % 10);
            addOne = (addOne + s1 + s2) >= 10 ? 1 : 0;
            size1--;
            size2--;
        }
        return sb.reverse().toString();
    }
}

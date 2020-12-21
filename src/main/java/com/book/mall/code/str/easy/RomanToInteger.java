package com.book.mall.code.str.easy;


/**
 * ClassName: RomanToInteger
 * Description:
 * 13. 罗马数字转整数
 * <p>
 * date: 2020/7/14 2:25 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    /**
     * 1.前一个字母与当前字母比较
     *   前一个比当前小，则当前减去前一个字母
     *   前一个大于等于当前字母，则当前加上前一个字母
     * @param s
     * @return
     */
    private static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum = sum - preNum;
            } else {
                sum = sum + preNum;
            }
            preNum = getValue(s.charAt(i));
        }
        sum = sum + preNum;
        return sum;
    }

    /**
     * 值转换
     *
     * @param ch
     * @return
     */
    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

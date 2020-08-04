package com.book.mall.leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: PlusOne
 * Description:
 * 66. 加一
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * date: 2020/8/4 11:30 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PlusOne {

    public static void main(String[] args) {
//        int[] digits = new int[] {1,2,3};
//        int[] digits = new int[] {4,3,2,1};
        int[] digits = new int[] {9,9};
        System.out.println(JSON.toJSONString(plusOne(digits)));
    }

    /**
     * 1.考虑999 需要进位的情况
     * 2.代码加减乘除考虑/ %等操作
     * 3.注意边界值 eg: i = 0; digits.length = 0等
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + add;
            digits[i] = value % 10;
            add = value / 10;
        }

        //999 需要进位
        if (add == 1) {
            int[] result = new int[digits.length + 1];
            //for loop or System.arrayCopy
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}

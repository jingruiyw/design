package com.book.mall.leetcode.doublePoint;

/**
 * ClassName: SumOfSquareNumbers
 * Description:
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 * date: 2020/6/11 11:50 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(99));
    }

    /**
     * 使用平方
     * time: O(sqrt(c))
     * space: O(1)
     * @param c
     * @return
     */
    private static boolean judgeSquareSum1(int c) {
        if (c < 0) {
            return false;
        }

        //使用int有溢出的风险
        for (long a = 0; a*a <= c; a++) {
            double b = Math.sqrt(c - a*a);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * 两数平方和：可以看做遍历一个到c的数组，查找a方+b方=c
     * time:O(sqrt(c))
     * space:O(1)
     *
     * @param c
     * @return
     */
    private static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            if ((left * left + right * right) > c) {
                right--;
            } else if ((left * left + right * right) < c) {
                left++;
            } else {
                System.out.println(left);
                System.out.println(right);
                return true;
            }
        }
        return false;
    }
}

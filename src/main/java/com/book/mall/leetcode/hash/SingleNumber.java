package com.book.mall.leetcode.hash;

/**
 * ClassName: SingleNumber
 * Description:
 * 136. 只出现一次的数字
 *
 * date: 2020/7/19 12:53 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 1.任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0= a
     * 2.任何数和其自身做异或运算，结果是 0，即 a ^ a = 0
     * 3.异或运算满足交换律和结合律，即 a ^ b ^ a  = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b
     *
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

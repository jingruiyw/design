package com.book.mall.code.dynamicprogramming;

/**
 * ClassName: MaxSubArray
 * Description:
 * 剑指 Offer 42. 连续子数组的最大和
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * <p>
 * date: 2021/2/13 4:12 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 动态规划：不使用额外数组
     * time:o(n)
     * space:o(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果上一个是正数，说明对结果有利, 为负数不作处理
            if (nums[i - 1] >= 0) {
                nums[i] += nums[i - 1];
            }
            //循环中取出最大值
            max = Math.max(nums[i], max);
        }
        return max;
    }

    /**
     * 动态规划:额外使用数组时
     * time:o(n)
     * space:o(n)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = nums[0];
        for (int j : dp) {
            if (j > res) {
                res = j;
            }
        }
        return res;
    }
}




























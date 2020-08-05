package com.book.mall.leetcode.array;


/**
 * ClassName: MaximumSubarray
 * Description:
 * 53. 最大子序和
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * date: 2020/8/4 12:53 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayV2(nums));
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    private static int maxSubArrayV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) {
                //前一位大于0，则将其加到自身；前一位小于0，保留自身；
                nums[i] += nums[i - 1];
            }
        }

        //取数组里面最大的值就是连续数组最大值
        int result = nums[0];
        for (Integer num : nums) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }


    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int result = 0;
        int max = nums[0];
        for (int num : nums) {
            if (result >= 0) {
                result += num;
            } else {
                //给差值复制当前的值
                result = num;
            }
            if (result > max) {
                max = result;
            }
        }
        return max;
    }
}

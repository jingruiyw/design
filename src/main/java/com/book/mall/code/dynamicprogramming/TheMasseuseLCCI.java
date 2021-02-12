package com.book.mall.code.dynamicprogramming;

/**
 * ClassName: TheMasseuseLCCI
 * Description:
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例 1：
 * <p>
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 * <p>
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 * <p>
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TheMasseuseLCCI {
    public int massage(int[] nums) {
        //状态转移方程：dp[i]=Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i])

        //空的直接返回
        int length = nums.length;
        if (length == 0) return 0;
        //长度为1，返回那个长度
        int[] dp = new int[length];
        dp[0] = nums[0];
        if (length == 1) return dp[0];
        //长度为2，比较两个之后返回
        dp[1] = nums[1];
        if (length == 2) return Math.max(dp[0], dp[1]);
        //长度为3，比较后返回
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);
        if (length == 3) return dp[2];

        int res = dp[2];
        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}





































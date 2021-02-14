package com.book.mall.code.dynamicProgramming;

/**
 * ClassName: MinCostClimbingStairs
 * Description:
 * 746. 使用最小花费爬楼梯
 * <p>
 * date: 2021/2/12 8:52 下午
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs2(cost));
    }

    /**
     * 动态规划：使用滚动数组,最终结果只与 i-1 和 i-2 的结果相关
     * time:o(n)
     * space:o(1)
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {
        //设标识到达下标的最小花费
        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * 动态规划
     * time:o(n)
     * space:o(n)
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        //设标识到达下标的最小花费
        int[] dp = new int[cost.length + 1];
        //可推状态转移方程 dp[i] = Min(dp[i - 1] + cost[i-1], dp[i-2] + cost[i - 2])
        //可选从下标为 0 或 1 的元素作为初始阶梯。故
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}





































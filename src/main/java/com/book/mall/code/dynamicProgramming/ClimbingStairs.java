package com.book.mall.code.dynamicProgramming;

/**
 * ClassName: ClimbingStairs
 * Description:
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * date: 2021/2/12 3:36 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ClimbingStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairs(1));
//        System.out.println(climbStairs(2));
//        System.out.println(climbStairs(3));

        System.out.println(climbStairs2(1));
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs2(3));
    }

    /**
     * 2.斐波那锲数列的递归实现
     * 但是时间和空间复杂度不符合要求
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    /**
     * 1.动态规划
     * <p>
     * 爬上 n-1n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     * 爬上 n-2n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * 故：f(x) = f(x-1) + f(x-2)
     * time:o(n)
     * space:o(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}




















































package com.book.mall.leetcode.doublePoint;

/**
 * ClassName: HappyNumber
 * Description:
 * 202. 快乐数
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * date: 2020/7/21 12:34 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class HappyNumber {

    public static void main(String[] args) {
//        System.out.println(getNext(121));
        System.out.println(isHappy(19));

    }

    /**
     * 1.双指针检查是否成环
     * 双指针变型例子
     *
     * @param n
     * @return
     */
    private static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (slow != fast && fast != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    /**
     * 获取下一个数的平方和
     *
     * @param n
     * @return
     */
    private static int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            total += d * d;
        }
        return total;
    }
}

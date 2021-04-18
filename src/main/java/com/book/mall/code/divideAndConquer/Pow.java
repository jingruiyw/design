package com.book.mall.code.divideAndConquer;

/**
 * ClassName: Pow
 * Description:
 * 50. Pow(x, n)
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * date: 2021/4/18 11:17 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Pow {
    public double myPow(double x, int n) {
        int m = n;
        if (n >= 0) {
            return pow(x, m);
        } else {
            return 1.0 / pow(x, -m);
        }
    }

    public double pow(double x, int n) {
        //终止条件
        if (n == 0) {
            return 1.0;
        }
        double y = pow(x, n/2);
        //判断是单数个还是双数个
        return n%2 == 0 ? y * y : y * y * x;
    }
}

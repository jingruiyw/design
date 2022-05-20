package com.book.mall.code;

/**
 * ClassName: FibonacciNumber
 * Description:
 * 509. 斐波那契数
 * date: 2020/12/19 1:20 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class FibonacciNumber {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fib2(i) + ",");
        }
    }

    /**
     * 非递归
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // 取模操作是为了让 相加不在int范围溢出，相乘不在long型溢出
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    /**
     * 递归实现
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
























package com.book.mall.code.binary;

/**
 * ClassName: Sqrt
 * Description:
 * 69. x 的平方根
 *
 * date: 2021/4/19 12:38 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Sqrt {
    public int mySqrt(int x) {
        //如果是0或1则直接返回本身
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1;
        int r = x;
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            //判断该数是否是平方数
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                //移动左右数值范围
                r = mid - 1;
            } else {
                l = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}

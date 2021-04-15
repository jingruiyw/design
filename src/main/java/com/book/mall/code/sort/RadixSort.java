package com.book.mall.code.sort;

import java.util.Arrays;

/**
 * ClassName: RadixSort
 * Description:
 * 基数排序: 对非负整数排序，是基于整数的每一位进行操作排序，按个，十，百，千的顺序；每一位排序时使用计数排序辅助
 * 稳定
 * time:o(d*(n + k)) d:最大值的位数， k进制数的范围（特指计数排序的范围）
 * space:o(n + k) k进制数的范围（特指计数排序的范围）
 * date: 2021/2/15 6:19 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 7, 3, 1, 4};
        // res : [1, 2, 3, 4, 4, 6, 7, 9]
        System.out.println(Arrays.toString(radixSort(array)));
    }

    /**
     * 基数排序
     *
     * @param arr
     * @return
     */
    private static int[] radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算每位数公式
        /**
         * 个位：num / 1 % 10
         * 十位：num / 10 % 10
         * 百位：num / 100 % 10
         * 千位：num / 1000 % 10
         */
        for (int deliver = 1; deliver <= max; deliver += 10) {
            arr = countingSort(arr, deliver);
        }
        return arr;
    }

    private static int[] countingSort(int[] arr, int deliver) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        //为了简便代码，十进制的最值确定0-9
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            //统计出现次数
            count[arr[i] / deliver % 10]++;
        }
        //累加次数：从索引1开始，把前面的次数加上自己
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //开辟新的数组
        int[] res = new int[arr.length];
        //从arr后面往前遍历元素，拿到具体元素的位置
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--count[arr[i] / deliver % 10]] = arr[i];
        }
        return res;
    }
}














































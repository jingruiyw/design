package com.book.mall.code.sort;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: QuickSort
 * Description:
 * 快速排序：选择基准元素，大于该元素的移至右侧，小于该元素的移至左侧
 * 不稳定
 * time:平均是o(nlogn),最坏为o(n^2)
 * date: 2021/2/15 12:58 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 7, 3, 1, 4};
        int[] array1 = {9, 4, 6, 2, 7, 3, 1, 4, 4};
        int[] array2 = {9, 4, 6, 2, 7, 3, 1, 4, 4};
        sort(array, 0, 7);
        //[1,2,3,4,4,6,7,9]
        System.out.println(JSON.toJSON(array));
        sort1(array1, 0, 8);
        System.out.println(JSON.toJSON(array1));
        sort2(array2, 0, 8);
        System.out.println(JSON.toJSON(array2));
    }

    private static void sort2(int[] arr, int l, int r) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int num = arr[left];
        while (left < right) {
            while (left < right && arr[right] > num) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= num) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left == right) {
                // 相等时，把基准值补回来
                arr[left] = num;
            }
        }
        sort2(arr, 0, l - 1);
        sort2(arr, l + 1, r);
    }

    private static void sort1(int[] arr, int l, int r) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        // 寻找基准下标
        int left = l;
        int right = r;
        // 基准
        int num = arr[left];
        while (left < right) {
            // 右侧
            while (left < right && arr[right] >= num) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }

            // 左侧
            while (left < right && arr[left] < num) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = num;
            }
        }
        sort1(arr, l, left - 1);
        sort1(arr, left + 1, r);
    }

    /**
     * 快排
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void sort(int[] arr, int l, int r) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        //寻找基准下标
        int left = l;
        int right = r;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        sort(arr, l, right - 1);
        sort(arr, right + 1, r);
    }
}






































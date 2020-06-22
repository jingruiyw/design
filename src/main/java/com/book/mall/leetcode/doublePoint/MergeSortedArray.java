package com.book.mall.leetcode.doublePoint;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * ClassName: MergeSortedArray
 * Description: 合并有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * date: 2020/6/15 11:19 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
//        int[] num1 = {0};
        int[] num2 = {2, 5, 6};
//        int[] num2 = {1};

//        mergeV1(num1, 3, num2, 3);
        mergeV2(num1, 3, num2, 3);
//        mergeV2(num1, 1, num2, 1);
    }

    /**
     * 2.双指针，从后往前比较
     * 时间复杂度 : O(n + m)O(n+m)。
     * 空间复杂度 : O(1)O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    /**
     * 1.合并后排序
     * time:O((m+n)log(m+n))
     * space:O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(JSON.toJSONString(nums1));
    }
}
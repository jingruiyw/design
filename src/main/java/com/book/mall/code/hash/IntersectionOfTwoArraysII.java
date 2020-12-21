package com.book.mall.code.hash;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * ClassName: IntersectionOfTwoArraysII
 * Description:
 * 350. 两个数组的交集 II
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * date: 2020/7/22 12:32 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(JSON.toJSONString(intersect(num1, num2)));
    }

    /**
     * 1.普通的暴力两边循环比较
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> largeMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (nums1.length > nums2.length) {
            for (int value : nums1) {
                if (!largeMap.containsKey(value)) {
                    largeMap.put(value, 1);
                } else {
                    largeMap.put(value, largeMap.get(value) + 1);
                }
            }

            for (int i : nums2) {
                if (largeMap.get(i) != null && largeMap.get(i) >= 0) {
                    result.add(i);
                    largeMap.put(i, largeMap.get(i) - 1);
                }
            }
        } else {
            for (int value : nums2) {
                if (!largeMap.containsKey(value)) {
                    largeMap.put(value, 1);
                } else {
                    largeMap.put(value, largeMap.get(value) + 1);
                }
            }

            for (int i : nums1) {
                if (largeMap.get(i) != null && largeMap.get(i) >= 0) {
                    result.add(i);
                    largeMap.put(i, largeMap.get(i) - 1);
                }
            }
        }
        int[] results = new int[result.size()];
        for (int n = 0; n < result.size(); n++) {
            results[n] = result.get(n);
        }
        return results;
    }
}

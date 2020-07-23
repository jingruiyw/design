package com.book.mall.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: IntersectionOfTwoArrays
 * Description:
 * 349. 两个数组的交集
 *
 * date: 2020/7/24 12:35 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class IntersectionOfTwoArrays {

    /**
     * 1.把长的放进set，遍历短的
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        for (int value : nums1) {
            numSet.add(value);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (numSet.contains(i)) {
                result.add(i);
            }
        }

        int[] resultArray = new int[result.size()];
        int i = 0;
        for (Integer val : result) {
            resultArray[i] = val;
            i++;
        }
        return resultArray;
    }
}

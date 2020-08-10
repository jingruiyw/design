package com.book.mall.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MajorityElement
 * Description:
 * 169. 多数元素
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * date: 2020/8/10 11:38 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementV2(nums));
    }

    /**
     * 2.排序后取中间值
     *
     * @param nums
     * @return
     */
    private static int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 1.暴力遍历
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        int max = 0;
        int result = 0;
        for (Integer key : counts.keySet()) {
            if (counts.get(key) > max) {
                max = counts.get(key);
                result = key;
            }
        }
        return result;
    }
}

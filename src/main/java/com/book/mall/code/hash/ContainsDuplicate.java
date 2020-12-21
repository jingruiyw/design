package com.book.mall.code.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: ContainsDuplicate
 * Description:
 * 217. 存在重复元素
 * <p>
 * date: 2020/7/16 12:21 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ContainsDuplicate {

    /**
     * 1.哈希表基本用法
     *
     * @param nums
     * @return
     */
    private static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}

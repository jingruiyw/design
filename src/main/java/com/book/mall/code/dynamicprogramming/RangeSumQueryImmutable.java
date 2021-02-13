package com.book.mall.code.dynamicprogramming;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: RangeSumQueryImmutable
 * Description:
 * 303. 区域和检索 - 数组不可变
 * <p>
 * 给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * date: 2021/2/13 6:10 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RangeSumQueryImmutable {
    private int[] data;

    public RangeSumQueryImmutable(int[] nums) {
        data = new int[nums.length + 1];
        //构造新数组，数组每一个元素为之前所有的项的累加和
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = data[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return data[j + 1] - data[i];
    }
}



































package com.book.mall.code.doublePoint;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: TrappingRainWater
 * Description:
 * 42. 接雨水
 * <p>
 * date: 2021/2/12 2:46 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    /**
     * 2.双指针
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        //声明两个指针和结果
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        //声明左右两边存储的最大值
        int leftMax = 0;
        int rightMax = 0;
        //循环条件是左指针小于又指针
        while (left < right) {
            if (height[left] < height[right]) {
                //说明右侧有更高的柱子
                if (height[left] >= leftMax) {
                    //需要更新左边最大
                    leftMax = height[left];
                } else {
                    //当前值比左边最大小，说明当前有低洼
                    water += leftMax - height[left];
                }
                //更新指针
                left++;
            } else {
                //左侧比右侧高，那么看右侧是否有低洼
                if (height[right] >= rightMax) {
                    //当前指针大于右侧最高，需要更新右边最大
                    rightMax = height[right];
                } else {
                    //小于当前存储的右侧最大，说明右侧有低洼
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        //返回存水量
        return water;
    }

    /**
     * 1.动态规划：
     * 分别获得左边最大数组和右边最大数组
     * 再遍历一次数组获得存水块
     * time:o(n)
     * space:o(n)
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        //返回值
        int water = 0;
        //边界条件：数组小于3不能存水
        if (height.length < 3) {
            return water;
        }

        //初始化左右最大长度数组
        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];
        //注意初始化数组的第一个值
        leftMaxArray[0] = height[0];
        rightMaxArray[height.length - 1] = height[height.length - 1];
        //分别获取左右最长数组
        for (int i = 1; i < height.length; i++) {
            int max = Math.max(leftMaxArray[i - 1], height[i]);
            leftMaxArray[i] = max;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            int max = Math.max(rightMaxArray[i + 1], height[i]);
            rightMaxArray[i] = max;
        }
        System.out.println("----> leftMaxArray:" + JSON.toJSONString(leftMaxArray));
        System.out.println("----> rightMaxArray:" + JSON.toJSONString(rightMaxArray));
        //遍历数组获取存水值
        for (int i = 0; i < height.length; i++) {
            //注意结果要累加
            water += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
        }
        return water;
    }
}




















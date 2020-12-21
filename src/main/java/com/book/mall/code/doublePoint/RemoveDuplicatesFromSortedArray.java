package com.book.mall.code.doublePoint;

/**
 * ClassName: RemoveDuplicatesFromSortedArray
 * Description:
 * 26. 删除排序数组中的重复项
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * date: 2020/7/29 11:49 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicatesV2(nums));
    }

    private static int removeDuplicatesV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            }
            nums[slow + 1] = nums[fast];
            fast++;
            slow++;
        }
        //将下标转成个数
        return slow + 1;
    }

    /**
     * 1.双指针
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        //将下标转成个数
        return slow + 1;
    }
}

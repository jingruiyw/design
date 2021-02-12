package com.book.mall.code.doublePoint;

/**
 * ClassName: LongPressedName
 * Description:
 * 925. 长按键入
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * date: 2021/2/12 1:39 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LongPressedName {

    public static void main(String[] args) {
        System.out.println("true : " + isLongPressedName("alex", "aaleex"));
        System.out.println("false : " + isLongPressedName("saeed", "ssaaedd"));
        System.out.println("true : " + isLongPressedName("leelee", "lleeelee"));
        System.out.println("true : " + isLongPressedName("laiden", "laiden"));
    }

    /**
     * 1. 双指针判断：判断str1 是否为 str2 的去重子串
     *
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) {
            return false;
        }
        if (name.length() > typed.length()) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while (p2 < typed.length()) {
            if (p1 < name.length() && name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            } else if (p2 > 0 && typed.charAt(p2) == typed.charAt(p2 - 1)) {
                //判p2>0的目的是为了判断是否是第一位不同
                p2++;
            } else {
                return false;
            }
        }
        //确认p1走到最终
        return p1 == name.length();
    }
}































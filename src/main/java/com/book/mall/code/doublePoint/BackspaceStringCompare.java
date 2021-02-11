package com.book.mall.code.doublePoint;

import java.util.Stack;

/**
 * ClassName: BackspaceStringCompare
 * Description:
 * 844. 比较含退格的字符串
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * date: 2021/2/11 5:11 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare2("ab#c", "ad#c"));
        System.out.println(backspaceCompare2("ab##", "c#d#"));
//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
//        System.out.println(backspaceCompare2("y#fo##f", "y#f#o##f"));
    }

    /**
     * 2、双指针
     * 两个指针分别指向两个字符串的末尾，遇到#则跳过
     * 1.当两个字符不相等时返回false
     * 2.当有一个指针先小于0时返回false
     *
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare2(String S, String T) {
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;
        int skip1 = 0;
        int skip2 = 0;
        //符合执行循环的条件
        while (p1 >= 0 || p2 >= 0) {
            //分别遍历两个字符串，利用skip变量进行字符串删除
            while (p1 >= 0) {
                if (S.charAt(p1) == '#') {
                    skip1++;
                    p1--;
                } else {
                    if (skip1 != 0) {
                        skip1--;
                        p1--;
                    } else {
                        break;
                    }
                }
            }
            while (p2 >= 0) {
                if (T.charAt(p2) == '#') {
                    skip2++;
                    p2--;
                } else {
                    if (skip2 != 0) {
                        skip2--;
                        p2--;
                    } else {
                        break;
                    }
                }
            }

            //比较字符串的每一个字符是否相等
            if (p1 >= 0 && p2 >= 0) {
                if (S.charAt(p1) != T.charAt(p2)) {
                    return false;
                }
            } else {
                //走到此处说明有一个字符串提前完成了遍历
                if (p1 >= 0 || p2 >= 0) {
                    return false;
                }
            }
            //指针递减
            p1--;
            p2--;
        }
        return true;
    }

    /**
     * 1、使用栈，遍历字符串，碰到#则弹栈
     * time: o(n+m)
     * space: o(n+m)
     *
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        String ns = modifyStr(S);
        String nt = modifyStr(T);
        return ns.equals(nt);
    }

    private static String modifyStr(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals("#")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push((str.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println("====>" + sb.toString());
        return sb.toString();
    }
}






































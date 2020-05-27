package com.book.mall.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/**
 * ClassName: ValidParenthesis
 * Description:
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * date: 2020/5/26 12:32 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ValidParenthesis {

    public static void main(String[] args) {
//        System.out.println(isValid("({[])}"));
//        System.out.println(isValid("{[]}"));
//        System.out.println(isValid("{"));
//        System.out.println(isValid(")"));
        System.out.println(isValid2("()"));
//        System.out.println("".length());
    }

    /**
     * time: O(n)
     * space: O(n) 最糟糕的情况要把所有((((((的放进栈里
     *
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        //先对字符串进行有无判断
        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> matcher = new HashMap<>();
        matcher.put(')', '(');
        matcher.put('}', '{');
        matcher.put(']', '[');

        Deque<Character> dq = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                dq.push(c);
            } else {
                //右括号与stack最顶端的一个比较，相同则移除元素
                if (dq.size() == 0 || !matcher.get(c).equals(dq.pop())) {
                    return false;
                }
            }
        }
        //不能忘记只有一个元素的情况
        return dq.size() == 0;
    }

    /**
     * 递归方法
     * 比较消耗内存，通过递归去除成对儿括号，比较消耗内存
     * @param s
     * @return
     */
    private static boolean isValid2(String s) {
//        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
//            return isValid2(s.replace("()", "").replace("[]", "").replace("{}", ""));
//        } else {
//            return "".equals(s);
//        }
        if(s.contains("()") || s.contains("{}") || s.contains("[]")) {
            return isValid2(s.replace("()", "").replace("{}", "").replace("[]", ""));
        }
        return s.length() == 0;
    }
}

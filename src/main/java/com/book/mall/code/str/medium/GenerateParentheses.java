package com.book.mall.code.str.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenerateParentheses
 * Description:
 * 22. 括号生成
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * date: 2021/4/18 11:11 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis("", res, n, n);
        return res;
    }

    public void generateParenthesis(String subList, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(subList);
            return;
        }
        if (left > 0) {
            generateParenthesis(subList + "(", res, left - 1, right);
        }
        //保证右括号要在左括号少一个，避免先出现右括号的情况
        if (right > left) {
            generateParenthesis(subList + ")", res, left, right - 1);
        }
    }
}

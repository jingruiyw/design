package com.book.mall.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FindWordsThatCanBeFormedByCharacters
 * Description:
 * 1160. 拼写单词
 * <p>
 * date: 2020/7/19 11:43 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
//        String[] words = new String[] {"cat","bt","hat","tree"};
//        String chars = "atach";
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        System.out.println(countCharacters(words, chars));
    }

    /**
     * 1.哈希表
     * char[] 中字符数量大于等于word中的字符数量
     *
     * @param words
     * @param chars
     * @return
     */
    private static int countCharacters(String[] words, String chars) {
        int length = 0;
        if (words == null || words.length == 0) {
            return length;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        //把字母放进哈希表
        for (int i = 0; i < chars.length(); i++) {
            if (charMap.containsKey(chars.charAt(i))) {
                charMap.put(chars.charAt(i), charMap.get(chars.charAt(i)) + 1);
            } else {
                charMap.put(chars.charAt(i), 1);
            }
        }

        //统计每个单词出现的次数
        Map<Character, Integer> temp = new HashMap<>();
        here:
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                //在char数组里没有的词，直接弹出
                if (!charMap.containsKey(word.charAt(j))) {
                    temp.clear();
                    continue here;
                }
                //如果存在则统计字符数目
                if (!temp.containsKey(word.charAt(j))) {
                    temp.put(word.charAt(j), 1);
                } else {
                    temp.put(word.charAt(j), temp.get(word.charAt(j)) + 1);
                }
                //检查数目是否超过char数组中的数目，超过也直接弹掉
                if (temp.get(word.charAt(j)) > charMap.get(word.charAt(j))) {
                    temp.clear();
                    continue here;
                }
            }
            temp.clear();
            System.out.println(word);
            length += word.length();
        }
        return length;
    }
}

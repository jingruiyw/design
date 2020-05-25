package com.book.mall.learn.util;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**
 * ClassName: PinyinUtil
 * Description:
 * date: 2020/4/14 1:51 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PinyinUtil {

    /**
     * 汉字转换位汉语拼音首字母，英文字符不变，特殊字符丢失 多音字取第一个音
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChars = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char nameChar : nameChars) {
            if (nameChar > 128) {
                try {
                    //取得当前汉字的所有全拼
                    String[] pinyin = net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(
                            nameChar, defaultFormat);
                    if (pinyin != null) {
                        //默认取多音字的第一个音首字母
                        pinyinName.append(pinyin[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(nameChar);
            }
        }
        return pinyinName.toString();
    }
}

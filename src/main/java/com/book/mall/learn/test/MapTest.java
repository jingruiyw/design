package com.book.mall.learn.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * ClassName: MapTest
 * Description: map重复的键值putAll会被覆盖
 * date: 2020/3/26 10:22 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MapTest {

	public static void main(String[] args) {
//		Map<String, String> testMap = new HashMap<>();
//		testMap.put("1", "1");
//		testMap.put("2", "1");
//		testMap.put("3", "1");
//		testMap.put("4", "1");
//
//		Map<String, String> test2Map = new HashMap<>();
//		test2Map.put("1", "2");
//		test2Map.put("2", "2");
//		test2Map.put("3", "2");
//		test2Map.put("5", "1");
//
//		String[] a = {"1","2","3"};
//		System.out.println(JSON.toJSONString(a));
//
//
//		testMap.putAll(test2Map);
//
//		System.out.println(JSON.toJSONString(testMap));

		List<String> strs = new ArrayList<>();
		strs.add("a");
		strs.add("b");
		strs.add("c");

		System.out.println(JSON.toJSONString(strs));

		String[] strings ={"a","b","c"};

		System.out.println(JSON.toJSONString(strings));


		List<String> list = splitPhoneNum("188,121,234,dasd,adas,afa,,");
		System.out.println(JSON.toJSONString(list));

	}

	public static List<String> splitPhoneNum(String phoneNum) {
		List<String> phoneNums = new ArrayList<>();
		//如果手机号为空则返回空数组
		if (StringUtils.isEmpty(phoneNum)) {
			return phoneNums;
		}

		//如果只有一个手机号则直接放进集合
		if (!phoneNum.contains(",")) {
			phoneNums.add(phoneNum);
			return phoneNums;
		}

		//多个手机号则拆分
		//多个手机号则拆分, 判断是否是,结尾，如果是则去掉最后的,
//		if (phoneNum.endsWith(",")) {
//			phoneNum = phoneNum.substring(0, phoneNum.length() - 1);
//		}
		String[] nums = phoneNum.split(",");
		phoneNums.addAll(Arrays.asList(nums));
		return phoneNums;
	}
}

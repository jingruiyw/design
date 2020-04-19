package com.book.mall.thread.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: ThreadLocalTest
 * Description:
 * date: 2020/1/30 10:24 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ThreadLocalTest {

	private volatile int num;

	public void method() {

		ThreadLocal threadLocal = new ThreadLocal();
		System.out.println("添加测试合并commit");
		System.out.println("添加测试合并commit01");
		System.out.println("添加测试合并commit01");
	}

	public static void main(String[] args) {

		List<mm> a = new ArrayList<>();
		for (int i = 1; i <3;i++) {
			mm n = new mm();
			n.setName(i + "mm");
			n.setCode("i +++" + i);
			a.add(n);
		}

		List<String> b = new ArrayList<>();
//		a.add("1");
//		a.add("2");
//		a.add("3");
//		a.add("4");
//		b.add("a");
//		b.add("b");
//		b.add("c");

//		a.addAll(b);

		Map<String, mm> noticeMap = a.stream().collect(Collectors.toMap( mm :: getName, Function.identity(), (key1, key2) -> key2));



		System.out.println(noticeMap.get("1mm").getCode());
		System.out.println(noticeMap.get("2mm"));
	}

	// 手机号码前三后四脱敏
	public static String mobileEncrypt(String mobile) {
		if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
			return mobile;
		}
		return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
	}


}

class mm{
	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

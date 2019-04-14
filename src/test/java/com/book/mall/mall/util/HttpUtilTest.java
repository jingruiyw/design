package com.book.mall.mall.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {

    private HttpUtil httpUtil = new HttpUtil();

    @Test
    public void httpTest() {

        String url = "http://localhost:8080/goods/list";
//        String url = "http://localhost:8080/goods/get?id=20";

        Map<String, String> param = new HashMap<>();
//        param.put("id", "20");
        param.put("name", "");
        param.put("kind", "");

        httpUtil.template = httpUtil.getTemplate();

        String resBean = httpUtil.postHttpForJson(url, param);
//        String resBean = httpUtil.getHttpForUrl(url, param);
        System.out.println(resBean);

    }
}

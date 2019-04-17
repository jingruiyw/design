package com.supply.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class HttpUtil {

    public static String postHttpForJson(String url, Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate template = new RestTemplate();

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = template.postForEntity(url, requestEntity, String.class);

        assert response != null;
        int code = response.getStatusCodeValue();
        if(code != 200) {
            return "请求异常, code :" + code;
        }
        return response.getBody();
    }

    public static String getHttpForUrl(String url, Map<String, String> params) {
        RestTemplate template = new RestTemplate();

        return template.getForObject(url, String.class, params);
    }
}

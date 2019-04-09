package com.book.mall.mall.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    /**
     * mybatis pageHelper配置
     */
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();

        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect","mysql");

        pageHelper.setProperties(p);
        return pageHelper;
    }
}

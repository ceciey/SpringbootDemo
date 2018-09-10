package com.invitation.card.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @ Author     ：haoWen
 * @ Date       ：Created in 17:13 2018/8/31
 * @ Description：配置监控拦截器, druid监控拦截器
 */
@WebFilter(filterName="druidWebStatFilter",
        urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
        })
public class DruidStatFilter extends DruidStatProperties.WebStatFilter {

}
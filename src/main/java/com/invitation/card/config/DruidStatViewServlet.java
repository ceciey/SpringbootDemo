package com.invitation.card.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @ Author     ：haoWen
 * @ Date       ：Created in 17:14 2018/8/31
 * @ Description：druid监控视图配置
 */
@WebServlet(urlPatterns = "/druid/*", initParams={
        @WebInitParam(name="loginUsername",value="admin"),// 用户名
        @WebInitParam(name="loginPassword",value="admin"),// 密码
        @WebInitParam(name="resetEnable",value="true")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends DruidStatProperties.StatViewServlet {
    private static final long serialVersionUID = 7359758657306626394L;
}

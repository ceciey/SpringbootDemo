package com.invitation.card.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invitation.card.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志统一处理
 * @author haoWen
 *
 */


@Slf4j
@Aspect
@Component
public class HttpAspect {
    /**
     * 1) execution(): 表达式主体
     * 2) 第一个public *号：表示返回类型， *号表示所有的类型
     * 3) 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.invitation.card.controller包、子孙包下所有类的方法。
     * 4) 第二个*号：表示类名，*号表示所有的类。
     * 5) *(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     *  &&
     *  public * com.invitation.card.controller..*.*(..)
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void log(){
    }

    /**
     * 方法执行之前执行
     * @param joinPoint 执行方法需要的入参
     */
    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //断言
        //attributes 不为空则继续执行
        //如果为false，则程序抛出AssertionError，并终止执行
        assert attributes != null : "ServletRequestAttributes 为空";
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url：{}",request.getRequestURL().toString());
        //method
        log.info("method：{}",request.getMethod());
        //ip
        log.info("ip：{}",request.getRemoteAddr());
        //类方法
        Signature signature = joinPoint.getSignature();
        log.info("class_method：{}.{}",signature.getDeclaringTypeName(),signature.getName());

        //参数
        //log.info("args：{}",joinPoint.getArgs());
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, Object> map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            map.put(name,request.getParameter(name));
        }
        log.info("params：{}",map);
    }

    /**
     * 方法执行后返回的对象
     * @param result 方法执行后返回数据
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(ResultBean result){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String value = mapper.writeValueAsString(result);
            log.info("result：{}",value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

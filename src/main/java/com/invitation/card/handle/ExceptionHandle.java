package com.invitation.card.handle;

import com.invitation.card.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean<Exception> handle(Exception e){
        log.error("访问失败",e);
        ResultBean<Exception> resultBean = new ResultBean<>();
        resultBean.setCode(400);
        resultBean.setMsg(e.getMessage());
        resultBean.setData(e);
        return resultBean;
    }
}

package com.sm.exception;

import com.sm.vo.ResultEntry;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultEntry<String> globalExceptionHandle(Exception e) {
        ResultEntry<String> result = new ResultEntry<>();
        e.printStackTrace();
        result.setCode(ResultEntry.EXCEPTION);
        result.setMsg(e.getMessage());
        return result;
    }
}

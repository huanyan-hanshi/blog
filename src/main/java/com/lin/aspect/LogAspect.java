package com.lin.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.lin.controller.*.*(..))")
    public void log(){}
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        logger.info("Request : {}", requestLog);
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterRuturn(Object result){
        logger.info("Result : {}",result);
    }
    @Data
    @AllArgsConstructor
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}

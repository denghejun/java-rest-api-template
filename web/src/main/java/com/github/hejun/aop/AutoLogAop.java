package com.github.hejun.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class AutoLogAop {
    public AutoLogAop() {

    }

    @Around(value = "@within(com.github.hejun.aop.AutoLog) || @annotation(com.github.hejun.aop.AutoLog)")
    public Object autoLogAop(ProceedingJoinPoint pjd) throws Throwable {
        Method method = ((MethodSignature) pjd.getSignature()).getMethod();
        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        if (autoLog != null) {
            String[] metas = autoLog.metaData();
            log.info("method executing: " + String.join(",", metas) + new Date().getTime());
        }

        return pjd.proceed();
    }
}

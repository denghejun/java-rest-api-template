package com.github.hejun.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    /**
     * .
     * all metaData you want to log into console log
     *
     * @return
     */
    String[] metaData() default {};
}

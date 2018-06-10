package com.hpeu.oa.controller;

import java.lang.annotation.*;

/**
 * @author ：郭银嘉
 * @create ： 2018/06/03 8:26
 * @description ：自定义注解 拦截Controller
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogController {

    /**
     * 描述业务操作
     * @return
     */
    String description() default "";
}

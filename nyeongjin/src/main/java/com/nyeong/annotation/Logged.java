package com.nyeong.annotation;

import java.lang.annotation.*;

/**
 * @Title: Logged
 * @Description: 自定义注解@Logged,被注解的controller和service包中的方法都会被Logger记录
 * @Author: Felix
 * @Date: 6/2/2018 13:23
 * @Version: 1.0
 **/


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Logged {

    /**
     * 参数名称
     */
    String[] value() default {"NoParameterNameIsGiven"};
}

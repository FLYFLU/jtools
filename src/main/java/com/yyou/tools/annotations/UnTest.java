package com.yyou.tools.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表明方法未进行测试
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface UnTest {
}

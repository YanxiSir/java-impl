package com.yanxisir.leetcode.zannos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可以做面试题
 *
 * @author: YanxiSir
 * @Date: 2020/2/26
 * @Sign: 心中田间，木行水上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface InterviewQuestion {
}

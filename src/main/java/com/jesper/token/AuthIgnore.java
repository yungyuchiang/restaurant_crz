package com.jesper.token;

import java.lang.annotation.*;

/**
 * 取消鉴权验证
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {
}

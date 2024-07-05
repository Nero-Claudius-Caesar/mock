package cn.nero.commons.mock.obj.annotations;

import java.lang.annotation.*;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MockName {

    String value() default "";

    boolean mockEnabled() default true;

}

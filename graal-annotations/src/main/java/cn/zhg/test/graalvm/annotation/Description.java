package cn.zhg.test.graalvm.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author zhhaogen
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, TYPE_PARAMETER, TYPE_USE })
@Repeatable(Descriptions.class)
public @interface Description {

    String value() default "";
}

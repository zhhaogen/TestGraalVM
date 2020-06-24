package cn.zhg.test.graalvm.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author zhhaogen
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, TYPE_PARAMETER, TYPE_USE })
public @interface Descriptions {

    Description[] value();
}

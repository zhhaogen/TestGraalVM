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
import cn.zhg.test.graalvm.enu.HttpMethod;

/**
 * @author zhhaogen
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
public @interface RequestMethod {

    HttpMethod[] value();
}

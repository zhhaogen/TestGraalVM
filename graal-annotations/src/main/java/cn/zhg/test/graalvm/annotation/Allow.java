package cn.zhg.test.graalvm.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author zhhaogen
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
public @interface Allow {

    AllowRule value() default AllowRule.ALL;

    public enum AllowRule {

        ALL("所有人"), LOGIN("登录用户"), ADMIN("管理员");

        private String msg;

        AllowRule(String msg) {
            this.msg = msg;
        }

        public String msg() {
            return msg;
        }
    }
}

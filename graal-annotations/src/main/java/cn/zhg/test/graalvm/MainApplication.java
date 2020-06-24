package cn.zhg.test.graalvm;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;
import cn.zhg.test.graalvm.annotation.Allow;
import cn.zhg.test.graalvm.annotation.Allow.AllowRule;
import cn.zhg.test.graalvm.annotation.Description;
import cn.zhg.test.graalvm.annotation.Descriptions;
import cn.zhg.test.graalvm.annotation.RequestMethod;
import cn.zhg.test.graalvm.enu.HttpMethod;
import cn.zhg.test.graalvm.server.UserServer;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        printServer(UserServer.class);
    }

    /**
     * @param clazz
     */
    private static void printServer(Class<?> clazz) {
        try {
            System.out.println(clazz.getName() + " 服务信息");
            System.out.println("服务描述:" + getDescriptions(clazz));
            System.out.println("-------------------");
            Method[] mths = clazz.getMethods();
            for (Method m : mths) {
                if (m.getDeclaringClass().equals(clazz)) {
                    System.out.println("方法:" + m.getName());
                    System.out.println("描述:" + getDescriptions(m));
                    System.out.println("请求方式:" + getRequestMethods(m));
                    System.out.println("允许:" + getAllow(m));
                    System.out.println("参数:");
                    Parameter[] ps = m.getParameters();
                    if (ps == null || ps.length == 0) {
                        System.out.println("无");
                    } else {
                        for (Parameter p : ps) {
                            System.out.println(p.getName() + " " + getDescriptions(p));
                        }
                    }
                    System.out.println("-------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param m
     * @return
     */
    private static String getAllow(AnnotatedElement m) {
        Allow an = m.getAnnotation(Allow.class);
        if (an != null) {
            return an.value().msg();
        }
        return "";
    }

    /**
     * @param m
     * @return
     */
    private static String getRequestMethods(AnnotatedElement m) {
        RequestMethod an = m.getAnnotation(RequestMethod.class);
        if (an != null) {
            HttpMethod[] vals = an.value();
            StringJoiner sb = new StringJoiner(",");
            for (HttpMethod v : vals) {
                sb.add(v.name().toLowerCase());
            }
            return sb.toString();
        }
        return "";
    }

    private static String getDescriptions(AnnotatedElement m) {
        Descriptions ans = m.getAnnotation(Descriptions.class);
        if (ans != null) {
            Description[] anes = ans.value();
            StringJoiner sb = new StringJoiner("\n");
            for (Description an : anes) {
                sb.add(an.value());
            }
            return sb.toString();
        } else {
            Description an = m.getAnnotation(Description.class);
            if (an != null) {
                return an.value();
            }
        }
        return "";
    }
}

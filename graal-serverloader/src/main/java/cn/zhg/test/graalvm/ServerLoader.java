package cn.zhg.test.graalvm;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

/**
 * @author zhhaogen
 */
public class ServerLoader {

    @SuppressWarnings("unchecked")
    public static <S> S load(Class<S> clazz) {
        try (InputStream is = ServerLoader.class.getResourceAsStream("/server/" + clazz.getName() + ".properties")) {
            Properties ps = new Properties();
            ps.load(is);
            String className = ps.getProperty("className");
            System.out.println("加载类:" + className);
            @SuppressWarnings("rawtypes")
            Class initClazz = Class.forName(className);
            S target = (S) initClazz.newInstance();
            Set<String> propertyNames = ps.stringPropertyNames();
            for (String key : propertyNames) {
                if (key.startsWith("field.")) {
                    String fieldName = key.substring(6);
                    Field field = initClazz.getDeclaredField(fieldName);
                    String valueStr = ps.getProperty(key);
                    boolean accessible = field.isAccessible();
                    if (!accessible) {
                        field.setAccessible(true);
                    }
                    field.set(target, toObject(valueStr, field.getType()));
                    if (!accessible) {
                        field.setAccessible(false);
                    }
                }
            }
            return target;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object toObject(String value, Class<?> type) {
        if (type.equals(String.class) || type.equals(CharSequence.class)) {
            return value;
        } else if (type.equals(Integer.class) || type.equals(int.class)) {
            return Integer.parseInt(value);
        }
        return null;
    }
}

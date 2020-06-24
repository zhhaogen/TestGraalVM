package cn.zhg.test.graalvm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import org.apache.logging.log4j.core.config.plugins.util.PluginRegistry;
import org.apache.logging.log4j.core.config.plugins.util.PluginType;
import org.junit.Test;

/**
 * @author zhhaogen
 */
public class TestPluginManager {

    /**
     * 列出所有插件
     */
    @Test
    public void listPlugins() {
        Map<String, List<PluginType<?>>> plugins = PluginRegistry.getInstance().loadFromMainClassLoader();
        Set<String> sets = new HashSet<>();
        plugins.forEach((key, list) -> {
            // System.out.println(key );
            for (PluginType<?> item : list) {
                sets.add(pluginJson(item.getPluginClass().getName()));
            }
        });
        // System.out.println("插件数量:"+sets.size());
        System.out.println(String.join(",\n", sets));
    }

    /**
     * @param className
     * @return
     */
    private String pluginJson(String className) {
        return "{\"name\":\"" + className + "\",\"allPublicConstructors\": true,\"allPublicMethods\" : true" + "}";
    }
}

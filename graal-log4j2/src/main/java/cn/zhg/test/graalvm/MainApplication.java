package cn.zhg.test.graalvm;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.status.StatusData;
import org.apache.logging.log4j.status.StatusListener;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

/**
 * @author zhhaogen
 */
public class MainApplication {

    private static String confSrc = "conf/log4j2.xml";

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (new File(confSrc).exists()) {
            System.setProperty(ConfigurationFactory.CONFIGURATION_FILE_PROPERTY, confSrc);
        } else {
            System.out.println(confSrc + "不存在,请配置!正在使用内置配置");
        }
        initStatusLogger();
        TestLogger.run();
    }

    /**
     * 配置StatusLogger,log的log
     */
    private static void initStatusLogger() {
        StatusLogger.getLogger().registerListener(new StatusListener() {

            public void close() throws IOException {
            }

            public void log(StatusData data) {
                StringBuilder sb = new StringBuilder();
                sb.append("[StatusLogger] " + data.getTimestamp() + " - " + data.getMessage().getFormattedMessage());
                if (data.getThrowable() != null) {
                    sb.append(data.getThrowable());
                }
                if (data.getStackTraceElement() != null) {
                    StackTraceElement st = data.getStackTraceElement();
                    sb.append("\n at " + st.getClassName() + "." + st.getMethodName() + "(" + st.getFileName() + ":" + st.getLineNumber() + ")");
                }
                System.err.println(sb);
            }

            public Level getStatusLevel() {
                return Level.TRACE;
            }
        });
    }
}

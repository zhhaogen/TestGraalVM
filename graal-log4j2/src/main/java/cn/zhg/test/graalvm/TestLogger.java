package cn.zhg.test.graalvm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhhaogen
 */
public class TestLogger {

    private static final Logger log = LogManager.getLogger(TestLogger.class);

    public static void run() {
        try {
            log.trace("跟踪消息");
            log.debug("调试消息");
            log.info("正常消息");
            log.warn("警告消息");
            log.error("错误消息", new NullPointerException("测试异常"));
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

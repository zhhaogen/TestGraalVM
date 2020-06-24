package cn.zhg.test.graalvm;

import org.apache.log4j.helpers.LogLog;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LogLog.setInternalDebugging(true);
        // 为什么要增加一个TestLogger类，就是为了让LogLog.setInternalDebugging跑在最前面
        TestLogger.run();
    }
}

package cn.zhg.test.graalvm;

import cn.zhg.test.graalvm.server.IUserServer;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        IUserServer server = ServerLoader.load(IUserServer.class);
        System.out.println(server.sayHello());
    }
}

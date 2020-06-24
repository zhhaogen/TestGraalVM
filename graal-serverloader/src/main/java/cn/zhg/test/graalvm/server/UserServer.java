package cn.zhg.test.graalvm.server;

/**
 * @author zhhaogen
 */
public class UserServer implements IUserServer {

    private String msg;

    private int level;

    @Override
    public String sayHello() {
        return "(" + level + ")" + msg + "," + System.currentTimeMillis();
    }
}

package cn.zhg.test.graalvm;

import java.util.Date;

/**
 * @author zhhaogen
 */
public class UserServer {

    private static final Date inittime;

    static {
        System.out.println("静态初始化" + new Date());
        inittime = new Date();
    }

    public UserServer() {
        System.out.println("构造初始化");
    }

    public String sayOK() {
        return "一切正常," + inittime;
    }
}

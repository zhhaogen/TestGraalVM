package cn.zhg.test.graalvm;

import cn.zhg.testweb.common.bean.Message;
import cn.zhg.testweb.common.enu.CodeEnu;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("code msg");
        System.out.println("=============");
        for (CodeEnu item : CodeEnu.values()) {
            System.out.println(item.code() + " " + item.msg());
        }
        System.out.println("=============");
        System.out.println(Message.ok("一切正常," + System.currentTimeMillis()));
    }
}

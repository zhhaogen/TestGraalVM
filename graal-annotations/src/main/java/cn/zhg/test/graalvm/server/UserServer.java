package cn.zhg.test.graalvm.server;

import cn.zhg.test.graalvm.annotation.RequestMethod;
import cn.zhg.test.graalvm.annotation.Allow.AllowRule;
import cn.zhg.test.graalvm.enu.HttpMethod;
import cn.zhg.test.graalvm.annotation.Allow;
import cn.zhg.test.graalvm.annotation.Description;

/**
 * @author zhhaogen
 */
@Description("用户服务")
public class UserServer {

    @Description("退出登录")
    @Description("这个应该始终返回成功")
    @RequestMethod({ HttpMethod.GET, HttpMethod.POST })
    @Allow()
    public void logout() {
    }

    @Description("登录")
    @RequestMethod(HttpMethod.POST)
    @Allow(AllowRule.LOGIN)
    public Object login(@Description("用户名") String name, @Description("密码") String password) {
        return null;
    }
}

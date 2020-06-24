package cn.zhg.test.graalvm;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8090;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception igr) {
            }
        }
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(group);
            boot.channel(NioServerSocketChannel.class);
            boot.handler(new LoggingHandler(LogLevel.DEBUG));
            boot.childHandler(new MainConfigure());
            Channel ch = boot.bind(port).sync().channel();
            System.out.println("服务已启动,请访问 http://localhost:" + port + "/");
            ch.closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}

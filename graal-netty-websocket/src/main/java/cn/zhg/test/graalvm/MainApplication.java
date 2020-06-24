package cn.zhg.test.graalvm;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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
        run(port);
    }

    /**
     * @param port
     */
    private static void run(final int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(group);
            boot.channel(NioServerSocketChannel.class);
            boot.handler(new LoggingHandler(LogLevel.DEBUG));
            boot.childHandler(new MainConfigure());
            boot.bind(port).addListener(new ChannelFutureListener() {

                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("服务启动成功,请访问 ws://localhost:" + port + "/");
                    } else {
                        System.err.println("服务启动失败," + future.cause());
                    }
                }
            }).sync().channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}

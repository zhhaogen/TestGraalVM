package cn.zhg.test.graalvm;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author zhhaogen
 */
public class MainConfigure extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpRequestDecoder(), new HttpResponseEncoder(), new MainHttpServerHandler());
    }
}

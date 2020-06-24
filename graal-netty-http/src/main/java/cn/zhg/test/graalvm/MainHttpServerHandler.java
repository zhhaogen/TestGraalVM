package cn.zhg.test.graalvm;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

/**
 * @author zhhaogen
 */
public class MainHttpServerHandler extends SimpleChannelInboundHandler<Object> {

    private HttpRequest request;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收内容:" + msg);
        if (// 接收请求头部分
        msg instanceof HttpRequest) {
            this.request = (HttpRequest) msg;
            if (HttpUtil.is100ContinueExpected(request)) {
                send100Continue(ctx);
            }
        }
        if (// 接收请求内容部分
        msg instanceof HttpContent) {
        // do nothing
        }
        if (// 接收最后请求内容
        msg instanceof LastHttpContent) {
            ByteBuf content = Unpooled.copiedBuffer("访问地址:" + request.uri() + ",时间:" + System.currentTimeMillis(), CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
            ctx.write(response);
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE, Unpooled.EMPTY_BUFFER);
        ctx.write(response);
    }

    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

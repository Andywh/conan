package io.conan.channel;


import java.util.function.Function;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public interface EventLoop extends EventLoopGroup {

    public void runInLoop(Function cb);
}

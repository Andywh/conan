package io.conan.bootstrap;

import io.conan.channel.EventLoop;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public class EventLoopThreadPool {

    EventLoop[] eventLoops;

    int index;

    public EventLoop getNextLoop() {
        index++;
        if (index == eventLoops.length) {
            index = 0;
        }
        return eventLoops[index];
    }
}

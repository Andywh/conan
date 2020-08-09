package io.conan.bootstrap;

import io.conan.callback.ThreadInitCallback;
import io.conan.channel.EventLoop;

import java.util.Stack;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public class EventLoopThreadPool {

    private EventLoop[] eventLoops;

    private Stack<EventLoopThread> threads;

    private Stack<EventLoop> loops;

    int index;

    public EventLoop getNextLoop() {
        index++;
        if (index == eventLoops.length) {
            index = 0;
        }
        return eventLoops[index];
    }

    public void start(ThreadInitCallback cb) {
        for (int i = 0; i < 1; i++) {
            EventLoopThread t = new EventLoopThread(cb);
            threads.push(t);
            loops.push(t.startLoop());
        }
    }
}

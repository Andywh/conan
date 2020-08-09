package io.conan.bootstrap;

import io.conan.callback.ThreadInitCallback;
import io.conan.channel.EventLoop;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

/**
 * Created by Ai Lun on 2020-08-10.
 */
public class EventLoopThread {

    private ThreadInitCallback cb;

    private EventLoop loop;

    private Semaphore cond;

    private Lock lock;

    private Thread thread;

    public EventLoopThread(ThreadInitCallback cb) {
        this.cb = cb;
    }

    public EventLoop startLoop() {
        thread.start();
        synchronized (this) {
            while (loop == null) {
                try {
                    cond.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return loop;
    }
}

package io.conan.bootstrap;

import java.net.InetAddress;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@FunctionalInterface
public interface CallBack {

    void run(int id, InetAddress address);

}

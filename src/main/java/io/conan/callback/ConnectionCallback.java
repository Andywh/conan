package io.conan.callback;

import io.conan.bootstrap.TcpConnectionPtr;

/**
 * Created by Ai Lun on 2020-08-07.
 */
@FunctionalInterface
public interface ConnectionCallback {
    public void callback(TcpConnectionPtr conn);
}

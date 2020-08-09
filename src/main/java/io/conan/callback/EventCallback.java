package io.conan.callback;

import io.conan.bootstrap.TcpConnectionPtr;

/**
 * Created by Ai Lun on 2020-08-10.
 */
public interface EventCallback {
    public void callback(TcpConnectionPtr conn);
}

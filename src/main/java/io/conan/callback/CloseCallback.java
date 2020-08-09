package io.conan.callback;

import io.conan.bootstrap.TcpConnection;

/**
 * Created by Ai Lun on 2020-08-10.
 */
public interface CloseCallback {

    public void callback(TcpConnection conn);
}

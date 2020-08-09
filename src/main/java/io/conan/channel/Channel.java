package io.conan.channel;


import io.conan.callback.EventCallback;
import io.conan.callback.ReadEventCallback;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Getter
@Setter
public class Channel {

    //ChannelId id();

    //EventLoop eventLoop();
    //
    //Channel parent();

    ReadEventCallback readCallback;

    EventCallback writeCallback;

    EventCallback closeCallback;

    EventCallback errorCallback;

}

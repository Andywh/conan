package io.conan.channel;


import java.util.Comparator;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public interface Channel extends Comparator<Channel> {

    //ChannelId id();

    EventLoop eventLoop();

    Channel parent();


}

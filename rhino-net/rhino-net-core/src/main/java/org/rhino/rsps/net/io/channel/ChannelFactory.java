package org.rhino.rsps.net.io.channel;

public interface ChannelFactory<T extends Channel> {

    /**
     * @return
     * @throws Exception
     */
    T createChannel() throws Exception;

    /**
     * @param channel
     * @return
     * @throws Exception
     */
    ChannelContext createChannelContext(T channel) throws Exception;

}

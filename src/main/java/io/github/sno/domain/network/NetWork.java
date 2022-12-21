package io.github.sno.domain.network;

import io.github.sno.monitor.NetStatus;

public class NetWork<T extends NetProtocal> {
    private final T net;

    public NetWork(T net) {
        this.net = net;
    }

    public NetStatus connect(){
        return net.connect();
    }

}

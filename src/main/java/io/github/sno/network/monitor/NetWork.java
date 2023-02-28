package io.github.sno.network.monitor;

import io.github.sno.network.NetStatus;

public class NetWork<T extends NetProtocal>{
    private final T net;

    public NetWork(T net) {
        this.net = net;
    }

    public NetStatus connect() {
        return net.connect();
    }
}

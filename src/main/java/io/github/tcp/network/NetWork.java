package io.github.tcp.network;

public class NetWork<T extends NetProtocal>{
    private final T net;

    public NetWork(T net) {
        this.net = net;
    }

    public NetStatus connect() {
        return net.connect();
    }
}

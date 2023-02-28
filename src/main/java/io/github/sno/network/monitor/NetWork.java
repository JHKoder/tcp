<<<<<<<< HEAD:src/main/java/io/github/sno/network/monitor/NetWork.java
package io.github.sno.network.monitor;

import io.github.sno.network.NetStatus;
========
package io.github.tcp.network;
>>>>>>>> main:src/main/java/io/github/tcp/network/NetWork.java

public class NetWork<T extends NetProtocal>{
    private final T net;

    public NetWork(T net) {
        this.net = net;
    }

    public NetStatus connect() {
        return net.connect();
    }
}

<<<<<<<< HEAD:src/main/java/io/github/sno/network/monitor/icmp/Icmp.java
package io.github.sno.network.monitor.icmp;

import io.github.sno.network.Host;
import io.github.sno.network.monitor.NetProtocal;
import io.github.sno.network.NetStatus;
========
package io.github.tcp.network.icmp;

import io.github.tcp.network.Host;
import io.github.tcp.network.NetProtocal;
import io.github.tcp.network.NetStatus;
>>>>>>>> main:src/main/java/io/github/tcp/network/icmp/Icmp.java

import java.io.IOException;
import java.net.InetAddress;

public class Icmp implements NetProtocal {
    private final Host host;

    public Icmp(Host host)  {
        this.host = host;
    }

    public NetStatus connect() {
        try {
            return connect(InetAddress.getByName(host.toString()));
        } catch (IOException e) {
            return NetStatus.NOT_CONNECT;
        }
    }

    private NetStatus connect(InetAddress inetAddress) throws IOException {
        if (inetAddress.isReachable(10_000)) {
            return NetStatus.OK;
        } else {
            return NetStatus.TIMEOUT;
        }
    }
}
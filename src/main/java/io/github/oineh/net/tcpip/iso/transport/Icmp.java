package io.github.oineh.net.tcpip.iso.transport;

import io.github.oineh.net.tcpip.Host;
import io.github.oineh.net.tcpip.NetStatus;
import io.github.oineh.net.tcpip.iso.IsoConnect;
import io.github.oineh.net.tcpip.iso.TcpIpProtocal;

import java.io.IOException;
import java.net.InetAddress;

public class Icmp  implements TcpIpProtocal, IsoConnect {
    private final Host host;

    public Icmp(Host host)  {
        this.host = host;
    }

    @Override
    public NetStatus connectStatus() {
        try {
            return connectStatus(InetAddress.getByName(host.toString()));
        } catch (IOException e) {
            return NetStatus.NOT_CONNECT;
        }
    }

    private NetStatus connectStatus(InetAddress inetAddress) throws IOException {
        if (inetAddress.isReachable(1_000)) {
            return NetStatus.OK;
        } else {
            return NetStatus.TIMEOUT;
        }
    }
}
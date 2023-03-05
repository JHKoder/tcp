package io.github.sno.network.monitor.tcpip.transport;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tasks.TaskResultData;
import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.TcpIpProtocal;
import io.github.sno.network.monitor.tcpip.NetStatus;

import java.io.IOException;
import java.net.InetAddress;

public class Icmp implements TcpIpProtocal , Task {
    private final Host host;

    public Icmp(Host host)  {
        this.host = host;
    }


    /** Icmp 프로토콜의 연결 확인  */
    public NetStatus connect() {
        try {
            return connect(InetAddress.getByName(host.toString()));
        } catch (IOException e) {
            return NetStatus.NOT_CONNECT;
        }
    }

    private NetStatus connect(InetAddress inetAddress) throws IOException {
        if (inetAddress.isReachable(1_000)) {
            return NetStatus.OK;
        } else {
            return NetStatus.TIMEOUT;
        }
    }

    @Override
    public TaskResultData job() {
        return connect();
    }
}
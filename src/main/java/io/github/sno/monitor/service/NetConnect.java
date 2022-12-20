package io.github.sno.monitor.service;

import io.github.sno.monitor.NetStatus;

import java.io.IOException;
import java.net.*;

/*
    TCP  - check
    ICMP - check
 */
public class NetConnect {
    private final static int TIME_OUT = 10_000;

    public NetStatus host(String hostName, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hostName, port), TIME_OUT);
            socket.close();
            return NetStatus.OK;
        } catch (SocketTimeoutException exception) {
            return NetStatus.TIMEOUT;
        } catch (IOException ignored) {
            return NetStatus.NOT_CONNECT;
        }
    }

    public NetStatus host(String hostName) {
        try {
            return connect(InetAddress.getByName(hostName));
        } catch (IOException e) {
            return NetStatus.NOT_CONNECT;
        }
    }
    private NetStatus connect(InetAddress inetAddress) throws IOException {
        if (inetAddress.isReachable(TIME_OUT)) {
            return NetStatus.OK;
        } else {
            return NetStatus.TIMEOUT;
        }
    }
}

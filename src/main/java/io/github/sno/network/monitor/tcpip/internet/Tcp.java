package io.github.sno.network.monitor.tcpip.internet;

import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.TcpIpProtocal;

import java.io.IOException;
import java.net.Socket;


public class Tcp implements TcpIpProtocal {

    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void shutdownSocket() {
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }

    public NetStatus connect() {
        throw new IllegalArgumentException("TCP/IP 요청 타입을 알수 없습니다.");
    }

}

package io.github.oineh.net.tcpip.iso.internet;

import io.github.oineh.net.tcpip.Host;
import io.github.oineh.net.tcpip.NetStatus;
import io.github.oineh.net.tcpip.iso.IsoConnect;
import io.github.oineh.net.tcpip.iso.TcpIpProtocal;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class Tcp  implements TcpIpProtocal, IsoConnect {

    private final Socket socket;
    private final Host host;
    private final int port;

    public Tcp(Host host, int port) {
        this.socket = new Socket();
        this.host = host;
        this.port = port;
    }

    @Override
    public NetStatus connectStatus() {
        try {
            socket.connect(new InetSocketAddress(host.toString(), port), 1_000);
            shutdownSocket();
            return NetStatus.OK;
        } catch (SocketTimeoutException ignored) {
            shutdownSocket();
            return NetStatus.TIMEOUT;
        } catch (IOException ignored) {
            shutdownSocket();
            return NetStatus.NOT_CONNECT;
        }
    }

    public void shutdownSocket() {
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }
}

package io.github.sno.network.monitor.tcpip.internet;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tasks.TaskResultData;
import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.NetStatus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Port extends Tcp implements Task {
    private final Host host;
    private final int port;

    public Port(Host host, int port) {
        this.host = host;
        this.port = port;
    }

    /** TCP 프로코콜의 port 연결 확인  */
    public NetStatus connect() {
        try {
            socket = new Socket();
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

    @Override
    public TaskResultData job() {
        return connect();
    }
}
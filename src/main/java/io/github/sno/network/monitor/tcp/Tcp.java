package io.github.sno.network.monitor.tcp;

import io.github.sno.network.monitor.Host;
import io.github.sno.network.monitor.NetProtocal;
import io.github.sno.network.monitor.NetStatus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;


public class Tcp implements NetProtocal {

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

    @Override
    public NetStatus connect() {
        throw new IllegalArgumentException("TCP/IP 요청 타입을 알수 없습니다.");
    }

    public static class Port extends Tcp {
        private final Host host;
        private final int port;

        public Port(Host host, int port) {
            this.host = host;
            this.port = port;
        }

        public NetStatus connect() {
            try {
                socket = new Socket();
                socket.connect(new InetSocketAddress(host.toString(), port), 10_000);
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
    }

    public static class Url extends Tcp {

        private final String url;

        public Url(String url) {
            this.url = url;
        }

        public NetStatus connect() {
            try {
                new URL(url).openConnection().connect();
                return NetStatus.OK;
            } catch (IOException url_not_connect) {
                return NetStatus.NOT_CONNECT;
            }
        }
    }
}

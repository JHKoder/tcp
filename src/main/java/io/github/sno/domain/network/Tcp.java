package io.github.sno.domain.network;

import io.github.sno.monitor.NetStatus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;


public class Tcp  implements NetProtocal {

    @Override
    public NetStatus connect() {
        throw new IllegalArgumentException("TCP/IP 요청 타입을 알수 없습니다.");
    }

    public static class Url extends Tcp{

        private String url;

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


    public static class Port extends Tcp{
        private final Host host;
        private final int port;

        public Port(Host host, int port) {
            this.host=host;
            this.port=port;
        }

        public NetStatus connect() {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host.toString(), port), 10_000);
                socket.close();
                return NetStatus.OK;
            } catch (SocketTimeoutException ignored) {
                return NetStatus.TIMEOUT;
            } catch (IOException ignored) {
                return NetStatus.NOT_CONNECT;
            }
        }

    }

}

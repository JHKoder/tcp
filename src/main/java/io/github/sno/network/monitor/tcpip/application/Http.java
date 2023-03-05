package io.github.sno.network.monitor.tcpip.application;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.TcpIpProtocal;

import java.io.IOException;
import java.net.URL;

public class Http implements TcpIpProtocal , Task {

    private final String url;

    public Http(String url) {
        this.url = url;
    }

    /** HTTP 프로토콜의 url 연결 확인 */
    public NetStatus connect() {
        try {
            new URL(url).openConnection().connect();
            return NetStatus.OK;
        } catch (IOException url_not_connect) {
            return NetStatus.NOT_CONNECT;
        }
    }

    @Override
    public NetStatus job() {
        return connect();
    }
}
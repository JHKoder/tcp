package io.github.oineh.net.tcpip.iso.application;

import io.github.oineh.net.tcpip.NetStatus;
import io.github.oineh.net.tcpip.iso.IsoConnect;
import io.github.oineh.net.tcpip.iso.TcpIpProtocal;

import java.io.IOException;
import java.net.URL;

public class Http  implements TcpIpProtocal, IsoConnect {

    private final String url;

    public Http(String url) {
        this.url = url;
    }

    @Override
    public NetStatus connectStatus() {
        try {
            new URL(url).openConnection().connect();
            return NetStatus.OK;
        } catch (IOException url_not_connect) {
            return NetStatus.NOT_CONNECT;
        }
    }
}
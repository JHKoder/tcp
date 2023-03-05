package io.github.sno.network.monitor.tcpip.dto;

import io.github.sno.network.monitor.tcpip.Host;


public class ConnectDto {
    private final String url;
    private final Host host;
    private final int port;

    public ConnectDto(String url, Host host, int port) {
        this.url = url;
        this.host = host;
        this.port = port;
    }

    public ConnectDto(Host host,int port){
        this("",host,port);
    }

    public ConnectDto(Host host){
        this("",host,-1);
    }

    public String getUrl() {
        return url;
    }

    public Host getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}

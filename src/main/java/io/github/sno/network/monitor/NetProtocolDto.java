package io.github.sno.network.monitor;


import io.github.sno.network.Host;

public class NetProtocolDto {
    private Host host;
    private String url;
    private int port;


    public NetProtocolDto(Host host, String url, int port) {
        this.host = host;
        this.url = url;
        this.port = port;
    }


    public static NetBuilder builder(){
        return new NetBuilder().builder();
    }

    public static class NetBuilder {

        private Host host;
        private String url;
        private int port;
        public NetBuilder builder() {
            return new NetBuilder();
        }

        public NetBuilder host(Host host) {
            this.host = host;
            return this;
        }

        public NetBuilder url(String url) {
            this.url = url;
            return this;
        }

        public NetBuilder port(int port) {
            this.port = port;
            return this;
        }

        public NetProtocolDto build() {
            return new NetProtocolDto(host, url, port);
        }
    }


    public Host getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }
}

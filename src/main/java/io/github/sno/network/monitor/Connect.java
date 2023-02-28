package io.github.sno.network.monitor;

import io.github.sno.network.*;
import io.github.sno.network.monitor.icmp.Icmp;
import io.github.sno.network.monitor.tcp.Tcp;


public class Connect {

    /** Icmp 프로토콜의 연결 확인  */
    public NetStatus findIcmp(Host host) {
        Icmp icmp = new Icmp(host);
        NetWork<Icmp> net = new NetWork<>(icmp);
        return net.connect();
    }

    /** TCP 프로토콜의 url 연결 확인 */
    public NetStatus findTcp(String url) {
        Tcp tcp = new Tcp.Url(url);
        NetWork<Tcp> net = new NetWork<>(tcp);
        return net.connect();
    }

    /** TCP 프로코콜의 port 연결 확인  */
    public NetStatus findTcp(Host host, int port) {
        Tcp tcp = new Tcp.Port(host, port);
        NetWork<Tcp> net = new NetWork<>(tcp);
        return net.connect();
    }
}

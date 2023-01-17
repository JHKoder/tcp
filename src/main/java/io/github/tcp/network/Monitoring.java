package io.github.tcp.network;

import io.github.tcp.network.icmp.Icmp;
import io.github.tcp.network.tcp.Tcp;


public class Monitoring {

    /** Icmp 프로토콜의 연결 확인  */
    public NetStatus IcmpStatus(Host host) {
        Icmp icmp = new Icmp(host);
        NetWork<Icmp> net = new NetWork<>(icmp);
        return net.connect();
    }

    /** TCP 프로토콜의 url 연결 확인 */
    public NetStatus TcpStatus(String url) {
        Tcp tcp = new Tcp.Url(url);
        NetWork<Tcp> net = new NetWork<>(tcp);
        return net.connect();
    }

    /** TCP 프로코콜의 port 연결 확인  */
    public NetStatus TcpStatus(Host host, int port) {
        Tcp tcp = new Tcp.Port(host, port);
        NetWork<Tcp> net = new NetWork<>(tcp);
        NetStatus status = net.connect();

        tcp.shutdownSocket();

        return status;
    }

    /** 프로토콜 각 연결 가능 여부 */
    public NetProtocolType connectNetProtocol(NetProtocolDto dto) {
        NetProtocolType netProtocolType = new NetProtocolType();
        if (IcmpStatus(dto.getHost()) == NetStatus.OK) {
            netProtocolType.updateIcmp(true);
        }
        if (TcpStatus(dto.getUrl()) == NetStatus.OK) {
            netProtocolType.updateTcpUrl(true);
        }
        if (TcpStatus(dto.getHost(),dto.getPort()) == NetStatus.OK) {
            netProtocolType.updateTcpPort(true);
        }
        return netProtocolType;
    }


}

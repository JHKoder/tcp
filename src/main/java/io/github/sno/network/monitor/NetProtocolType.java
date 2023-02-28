package io.github.sno.network.monitor;

import java.util.Set;

public class NetProtocolType {
    private final boolean icmpStatus;
    private final boolean tcpUrlStatus;
    private final boolean tcpPortStatus;

    public NetProtocolType(Set<NetType> netTypes) {
        System.out.println("생성자"+netTypes.toString());
        this.icmpStatus = netTypes.contains(NetType.ICMP);
        this.tcpUrlStatus = netTypes.contains(NetType.TCP_URL);
        this.tcpPortStatus = netTypes.contains(NetType.TCP_PORT);
    }

    public boolean isIcmpStatus() {
        return icmpStatus;
    }

    public boolean isTcpUrlStatus() {
        return tcpUrlStatus;
    }

    public boolean isTcpPortStatus() {
        return tcpPortStatus;
    }
}

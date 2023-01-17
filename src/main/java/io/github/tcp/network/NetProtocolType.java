package io.github.tcp.network;

public class NetProtocolType {
    private boolean icmpStatus;
    private boolean tcpUrlStatus;
    private boolean tcpPortStatus;

    public boolean isIcmpStatus() {
        return icmpStatus;
    }

    public boolean isTcpUrlStatus() {
        return tcpUrlStatus;
    }

    public boolean isTcpPortStatus() {
        return tcpPortStatus;
    }

    public void updateIcmp(boolean icmpStatus) {this.icmpStatus = icmpStatus;}

    public void updateTcpUrl(boolean tcpUrlStatus) {
        this.tcpUrlStatus = tcpUrlStatus;
    }

    public void updateTcpPort(boolean tcpPortStatus) {
        this.tcpPortStatus = tcpPortStatus;
    }
}

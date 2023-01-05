package io.github.sno.network;

public class NetProtocolType {
    private boolean icmpStatus;
    private boolean tcpUrlStatus;
    private boolean tcpPortStatus;

    public void updateIcmp(boolean icmpStatus) {
        this.icmpStatus = icmpStatus;
    }

    public void updateTcpUrl(boolean tcpUrlStatus) {
        this.tcpUrlStatus = tcpUrlStatus;
    }

    public void updateTcpPort(boolean tcpPortStatus) {
        this.tcpPortStatus = tcpPortStatus;
    }
}

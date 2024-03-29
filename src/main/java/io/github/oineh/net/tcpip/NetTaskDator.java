package io.github.oineh.net.tcpip;

import io.github.oineh.net.task.TaskResultDator;
import io.github.oineh.net.tcpip.iso.IsoConnect;

public class NetTaskDator implements TaskResultDator {
    private final IsoConnect connect;
    private final NetStatus data;

    public NetTaskDator(IsoConnect connect, NetStatus data) {
        this.connect = connect;
        this.data = data;
    }
}

package io.github.sno.monitoring.tcpip.internet;

import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.internet.Port;
import io.github.sno.network.monitor.tcpip.internet.Tcp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TCP")
public class TcpTest {

    @Test
    void Port_연결() {
        Host host = new Host(127, 0, 0, 1);
        Tcp tcp = new Port(host, 5000);

        NetStatus status = tcp.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

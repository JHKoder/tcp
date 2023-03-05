package io.github.sno.monitoring.tcpip.transport;

import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.transport.Icmp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ICMP")
public class IcmpTest {

    @Test
    void 연결() {
        Host host = Host.from("127.0.0.1");
        Icmp icmp = new Icmp(host);

        NetStatus status = icmp.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

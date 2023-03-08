package io.github.oineh.net.tcpip.iso.transport;

import io.github.oineh.net.tcpip.Host;
import io.github.oineh.net.tcpip.NetStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ICMP")
public class IcmpTest {

    @Test
    void 연결확인() {
        Host host = Host.from("127.0.0.1");
        Icmp icmp = new Icmp(host);

        NetStatus status = icmp.connectStatus();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

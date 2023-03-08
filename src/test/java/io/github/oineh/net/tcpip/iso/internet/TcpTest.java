package io.github.oineh.net.tcpip.iso.internet;

import io.github.oineh.net.tcpip.Host;
import io.github.oineh.net.tcpip.NetStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TCP")
public class TcpTest {

    @Test
    void 연결확인() {
        Host host = new Host(127, 0, 0, 1);
        Tcp tcp = new Tcp(host, 5000);

        NetStatus status = tcp.connectStatus();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

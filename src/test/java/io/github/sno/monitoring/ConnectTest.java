package io.github.sno.monitoring;

import io.github.sno.network.monitor.Host;
import io.github.sno.network.monitor.NetStatus;
import io.github.sno.network.monitor.NetWork;
import io.github.sno.network.monitor.icmp.Icmp;
import io.github.sno.network.monitor.tcp.Tcp;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectTest {

    @Test
    void TCP_url_연결() {
        Tcp tcp = new Tcp.Url("https://naver.com");
        NetWork<Tcp> net = new NetWork<>(tcp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }

    @Test
    void TCP_Port_연결() {
        Host host = new Host(127, 0, 0, 1);
        Tcp tcp = new Tcp.Port(host, 5000);
        NetWork<Tcp> net = new NetWork<>(tcp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }

    @Test
    void ICMP_연결() {
        Host host = Host.from("127.0.0.1");
        Icmp icmp = new Icmp(host);
        NetWork<Icmp> net = new NetWork<>(icmp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

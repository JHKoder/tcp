package io.github.sno.monitoring;

import io.github.sno.network.Host;
import io.github.sno.network.NetStatus;
import io.github.sno.network.NetWork;
import io.github.sno.network.icmp.Icmp;
import io.github.sno.network.tcp.Tcp;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

public class NetWorkTest {


    @Test
    void TCP_url_연결() {
        Tcp tcp = new Tcp.Url("https://naver.com");
        NetWork<Tcp> net = new NetWork<>(tcp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }

    @Test
    void TCP_Port_연결_테스트() {
        Host host = new Host(127, 0, 0, 1);
        Tcp tcp = new Tcp.Port(host, 5000);
        NetWork<Tcp> net = new NetWork<>(tcp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }

    @Test
    void TCP_Port_연결시_소켓_가져오기() {
        Host host = new Host(127, 0, 0, 1);
        Tcp tcp = new Tcp.Port(host, 5000);
        NetWork<Tcp> net = new NetWork<>(tcp);

        NetStatus status = net.connect();
        Socket socket = tcp.getSocket();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
        assertThat(socket).isNotNull();
    }

    @Test
    void ICMP_연결_테스트() {
        Host host = Host.from("127.0.0.1");
        Icmp icmp = new Icmp(host);
        NetWork<Icmp> net = new NetWork<>(icmp);

        NetStatus status = net.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }

}

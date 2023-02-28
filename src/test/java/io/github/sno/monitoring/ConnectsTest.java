package io.github.sno.monitoring;

import io.github.sno.network.monitor.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectsTest {

    @Test
    void 연결가능한_상태_중_icmp_보기() {
        Host host = new Host(127, 0, 0, 1);
        NetProtocolDto dto = new NetProtocolDto(host,"httpsss://navsser.com",8088);
        Connects connects = new Connects(new Connect());

        NetProtocolType type = connects.connectNetProtocol(dto);

        assertThat(type.isIcmpStatus()).isTrue();

    }
}

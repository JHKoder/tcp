package io.github.sno.monitoring;

import io.github.sno.network.Host;
import io.github.sno.network.monitor.Connect;
import io.github.sno.network.monitor.Connects;
import io.github.sno.network.monitor.NetProtocolDto;
import io.github.sno.network.monitor.NetProtocolType;
import org.junit.jupiter.api.Test;

public class ConnectsTest {

    @Test
    void 연결가능한_상태_보기() {
        Host host = new Host(127, 0, 0, 1);
        NetProtocolDto dto = new NetProtocolDto(host,"httpsss://navsser.com",8088);
        Connects connects = new Connects(new Connect());

        NetProtocolType type = connects.connectNetProtocol(dto);

    }
}

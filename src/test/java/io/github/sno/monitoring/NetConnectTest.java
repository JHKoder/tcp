package io.github.sno.monitoring;

import io.github.sno.monitor.NetStatus;
import io.github.sno.monitor.service.NetConnect;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NetConnectTest {

    @Test
    void hostGetTest(){
        NetConnect netConnect = new NetConnect();

        NetStatus status = netConnect.host("127.0.0.1");

        Assertions.assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

package io.github.sno.monitoring.tcpip.application;

import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.application.Http;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HTTP")
public class HttpTest {

    @Test
    void url_연결() {
        Http http = new Http("https://naver.com");

        NetStatus status = http.connect();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

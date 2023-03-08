package io.github.oineh.net.tcpip.iso.application;

import io.github.oineh.net.tcpip.NetStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HTTP")
public class HttpTest {

    @Test
    void url_연결_확인() {
        Http http = new Http("https://naver.com");

        NetStatus status = http.connectStatus();

        assertThat(status.name()).isEqualTo(NetStatus.OK.name());
    }
}

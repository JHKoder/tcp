package io.github.sno.monitoring.tasks;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tasks.TaskExecutor;
import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.NetStatus;
import io.github.sno.network.monitor.tcpip.NetTaskDator;
import io.github.sno.network.monitor.tcpip.application.Http;
import io.github.sno.network.monitor.tcpip.transport.Icmp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Task")
public class TaskExecutorTest {

    @Test
    void TCP_IP_비동기_실행() {
        Http http = new Http("https://naver.com");
        Icmp icmp1 = new Icmp( Host.from("127.0.0.1"));
        Icmp icmp2 = new Icmp(Host.from("127.0.0.2"));

        HashMap<Task,NetTaskDator> result = TaskExecutor.async(
                http,icmp1,icmp2
        );

        assertAll(() -> assertThat(result.size()).isEqualTo(3),
                () -> assertEquals(result.get(http),NetStatus.OK),
                () -> assertEquals(result.get(icmp1),NetStatus.OK),
                () -> assertEquals(result.get(icmp2),NetStatus.TIMEOUT));
    }
}

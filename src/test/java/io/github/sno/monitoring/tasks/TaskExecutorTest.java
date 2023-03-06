package io.github.sno.monitoring.tasks;

import io.github.sno.network.monitor.tasks.TaskExecutor;
import io.github.sno.network.monitor.tasks.TaskResultDator;
import io.github.sno.network.monitor.tcpip.Host;
import io.github.sno.network.monitor.tcpip.NetTaskData;
import io.github.sno.network.monitor.tcpip.application.Http;
import io.github.sno.network.monitor.tcpip.transport.Icmp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

@DisplayName("Task")
public class TaskExecutorTest {

    @Test
    void TCP_IP_비동기_실행(){
        Http http = new Http("https://naver.com");
        Icmp icmp1 = new Icmp( Host.from("127.0.0.1"));
        Icmp icmp2 = new Icmp(Host.from("127.0.0.2"));

        HashSet<TaskResultDator> result = TaskExecutor.<NetTaskData> async(
                http,icmp1,icmp2
        );
//        assertThat(result.stream(). ));stream
//        assertEquals(obj2, set.stream().filter(o -> o.getName().equals("Banana")).findFirst().orElse(null));
    }
}

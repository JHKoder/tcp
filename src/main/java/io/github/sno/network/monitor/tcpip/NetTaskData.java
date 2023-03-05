package io.github.sno.network.monitor.tcpip;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tasks.TaskResultData;
import io.github.sno.network.monitor.tasks.TaskResultDator;

public class NetTaskData implements TaskResultDator {
    private final Task task;
    private final NetStatus data;

    public NetTaskData(Task task, TaskResultData data) {
        this.task =  task;
        this.data = (NetStatus) data;
    }

    public static TaskResultDator of(Task task, TaskResultData data) {
        return new NetTaskData(task,data);
    }
}

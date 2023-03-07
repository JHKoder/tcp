package io.github.sno.network.monitor.tcpip;

import io.github.sno.network.monitor.tasks.Task;
import io.github.sno.network.monitor.tasks.TaskResultData;
import io.github.sno.network.monitor.tasks.TaskResultDator;

public class NetTaskDator implements TaskResultDator {
    private final Task task;
    private final NetStatus data;

    public NetTaskDator(Task task, TaskResultData data) {
        this.task =  task;
        this.data = (NetStatus) data;
    }

    @Override
    public boolean equalsTask(Task task) {
        return this.task.equals(task);
    }
}

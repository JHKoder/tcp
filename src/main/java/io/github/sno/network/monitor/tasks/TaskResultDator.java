package io.github.sno.network.monitor.tasks;

public interface TaskResultDator {

    static TaskResultDator of(Task task, TaskResultData data) {
        throw new ClassCastException("");
    }
}

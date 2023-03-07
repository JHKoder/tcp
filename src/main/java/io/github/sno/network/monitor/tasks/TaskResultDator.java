package io.github.sno.network.monitor.tasks;

public interface TaskResultDator<R> {

    <T extends TaskResultDator<R>> T of(Task task, TaskResultData data);

    boolean equalsTask(Task http);

}

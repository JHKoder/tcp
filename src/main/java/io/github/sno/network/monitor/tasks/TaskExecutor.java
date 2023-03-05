package io.github.sno.network.monitor.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TaskExecutor {

    public static <T extends TaskResultDator> HashSet<TaskResultDator> async(Task... tasks) {

        CompletableFuture<HashSet<TaskResultDator>> taskFuture =
                CompletableFuture.supplyAsync(HashSet::new);

        Arrays.stream(tasks).forEach(task -> {
            taskFuture.thenApply(set -> {
                set.add(T.of(task, task.job()));
                return set;
            });
        });

        return getFuture(taskFuture);
    }

    private static HashSet<TaskResultDator> getFuture(CompletableFuture<HashSet<TaskResultDator>> taskFuture) {
        try {
            return taskFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            return new HashSet<>();
        }
    }
}

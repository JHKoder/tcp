package io.github.sno.network.monitor.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TaskExecutor {


    public static <R> HashMap<Task, R> async(Task... tasks) {

        CompletableFuture<HashMap<Task, R>> taskFuture = CompletableFuture.supplyAsync(HashMap::new);

        Arrays.stream(tasks).forEach(task -> {
            taskFuture.thenApply(map -> {
                map.put(task, (R) task.job());
                return map;
            });
        });

        return getFuture(taskFuture);
    }

    private static <R> HashMap<Task, R> getFuture(CompletableFuture<HashMap<Task, R>> taskFuture) {
        try {
            return taskFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            return new HashMap<>();
        }
    }
}

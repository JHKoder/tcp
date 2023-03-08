package io.github.oineh.net.task;

import io.github.oineh.net.tcpip.iso.IsoConnect;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class TaskExecutor {

    /**
     * 동시성 문제를 해결하기 위해
     * `ConcurrentHashMap`을 사용하고 CompletableFuture.runAsync()를 사용하여 작업을 실행합니다.
     * 작업이 완료되면 CompletableFuture.allOf()를 사용하여 모든 작업이 완료될 때까지 기다린 다음으로 넘어갑니다.
     *
     * @param tasks
     * @return ConcurrentHashMap<IsoStatus, R>
     * @param <R>
     */
    public static <R> ConcurrentHashMap<IsoConnect, R> async(IsoConnect... tasks) {
        ConcurrentHashMap<IsoConnect, R> resultMap = new ConcurrentHashMap<>();
        CompletableFuture<?>[] futures = Arrays.stream(tasks)
                .map(task -> CompletableFuture.runAsync(() -> resultMap.put(task, (R) task.connectStatus())))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        return resultMap;
    }
}

package io.github.sno.network.monitor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Connects {

    private final Connect connect;

    public Connects(Connect connect) {
        this.connect = connect;
    }

    /**
     * 프로토콜 각 연결 가능 여부
     */
    public NetProtocolType connectNetProtocol(NetProtocolDto dto) {
        Set<NetType> netTypes = new ConnectTask(
                new ConnectIcmpTask(connect, dto),
                new ConnectTcpUrlTask(connect, dto),
                new ConnectPortTask(connect, dto)
        ).connect();

        return new NetProtocolType(netTypes);
    }

    private static class ConnectTask {
        private final ConnectIcmpTask connectIcmpTask;
        private final ConnectTcpUrlTask connectTcpUrlTask;
        private final ConnectPortTask connectPortTask;
        private final Set<NetType> netTypes;

        public ConnectTask(ConnectIcmpTask connectIcmpTask, ConnectTcpUrlTask connectTcpUrlTask, ConnectPortTask connectPortTask) {
            this.connectIcmpTask = connectIcmpTask;
            this.connectTcpUrlTask = connectTcpUrlTask;
            this.connectPortTask = connectPortTask;
            this.netTypes = new HashSet<>();
        }

        public Set<NetType> connect() {
            threadPoolLife(connectIcmpTask, connectTcpUrlTask, connectPortTask);

            netTypes.add(connectIcmpTask.getNetType());
            netTypes.add(connectTcpUrlTask.getNetType());
            netTypes.add(connectPortTask.getNetType());

            return netTypes;
        }

        private void threadPoolLife(Runnable... tasks) {
            ExecutorService pool = Executors.newFixedThreadPool(3);

            Arrays.stream(tasks).forEach(pool::execute);

            shutdown(pool);
        }

        private void shutdown(ExecutorService pool){
            pool.shutdown();
            while (!pool.isTerminated()) {
                //ignore
            }
        }
    }

    private static class ConnectIcmpTask implements Runnable {
        private final TaskHandler taskHandler;
        private final Connect connect;
        private final NetProtocolDto dto;

        public ConnectIcmpTask(Connect connect, NetProtocolDto dto) {
            this.taskHandler = new TaskHandler();
            this.connect = connect;
            this.dto = dto;
        }

        @Override
        public void run() {
            taskHandler.connect();
        }

        public NetType getNetType() {
            return taskHandler.netType;
        }


        private class TaskHandler {
            private NetType netType;

            public void connect() {
                if (connect.findIcmp(dto.getHost()) == NetStatus.OK) {
                    this.netType = NetType.ICMP;
                }
            }
        }
    }

    private static class ConnectTcpUrlTask  implements Runnable {
        private final TaskHandler taskHandler;
        private final Connect connect;
        private final NetProtocolDto dto;

        public ConnectTcpUrlTask(Connect connect, NetProtocolDto dto) {
            this.taskHandler = new TaskHandler();
            this.connect = connect;
            this.dto = dto;
        }

        @Override
        public void run() {
            taskHandler.connect();
        }

        public NetType getNetType() {
            return taskHandler.netType;
        }

        private class TaskHandler {
            private NetType netType;

            public void connect() {
                if (connect.findTcp(dto.getUrl()) == NetStatus.OK) {
                    this.netType = NetType.TCP_URL;
                }
            }
        }
    }

    private static class ConnectPortTask implements Runnable {
        private final TaskHandler taskHandler;
        private final Connect connect;
        private final NetProtocolDto dto;

        public ConnectPortTask(Connect connect, NetProtocolDto dto) {
            this.taskHandler = new TaskHandler();
            this.connect = connect;
            this.dto = dto;
        }

        @Override
        public void run() {
            taskHandler.connect();
        }

        public NetType getNetType() {
            return taskHandler.netType;
        }

        private class TaskHandler {
            private NetType netType;

            public void connect() {
                if (connect.findTcp(dto.getHost(), dto.getPort()) == NetStatus.OK) {
                    this.netType = NetType.TCP_PORT;
                }
            }
        }
    }
}

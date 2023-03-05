package io.github.sno.network.monitor.tcpip;

import io.github.sno.network.monitor.tasks.TaskResultData;

public enum NetStatus implements TaskResultData {
    TIMEOUT,
    NOT_CONNECT,
    OK;

    public boolean isOk() {
        return this == OK;
    }
}

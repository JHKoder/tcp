package io.github.oineh.net.tcpip;

import io.github.oineh.net.task.TaskResultData;

public enum NetStatus implements TaskResultData {
    TIMEOUT,
    NOT_CONNECT,
    OK;

    public boolean isOk() {
        return this == OK;
    }
}

package io.github.sno.network;

public record NetWork<T extends NetProtocal>(T net) {

    public NetStatus connect() {
        return net.connect();
    }

}

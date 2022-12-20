package io.github.sno.domain.company;

import lombok.Getter;

@Getter
public class Company {

    private final String name;
    private final String host;
    private final String port;

    private Company(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public static Company of(String name, String host, String port) {
        return new Company(name, host,port);
    }

}

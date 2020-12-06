package com.glqdlt.myho.intergration;

public interface SshDetail {

    String getIp();

    String getUserName();

    String getPassword();

    default Integer getPort() {
        return 22;
    }
}

package com.glqdlt.myho.intergration;

public class TargetSystemWithSsh extends TargetSystem implements SshDetail {

    private String userName;
    private String password;
    private Integer port = 22;

    @Override
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

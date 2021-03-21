package com.glqdlt.myho.intergration;

public enum SSHCommands implements SSHCommand {

    SHUTDOWN("shutdown /P");

    SSHCommands(String command) {
        this.command = command;
    }

    private String command;

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getCommand() {
        return command;
    }
}

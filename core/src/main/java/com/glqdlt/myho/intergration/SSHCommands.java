package com.glqdlt.myho.intergration;

public enum SSHCommands implements SSHCommand {

    SHUTDOWN("sudo shutdown -P 00");

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

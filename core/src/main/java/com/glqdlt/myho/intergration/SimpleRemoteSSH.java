package com.glqdlt.myho.intergration;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;

public class SimpleRemoteSSH implements RemoteSSH {

    private String userName;
    private String password;
    private int port = 22;
    private String ip;

    public SimpleRemoteSSH(String userName, String password, String ip) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        SimpleRemoteSSH aa = new SimpleRemoteSSH(args[0], args[1], args[2]);
        aa.oneTimeExecCommand(SSHCommands.SHUTDOWN);
    }

    public void oneTimeExecCommand(SSHCommand command) throws Exception {

        ChannelExec channel = null;
        Session session = null;
        try {
            session = getSession();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command.getCommand());
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            while (channel.isConnected()) {
                Thread.sleep(100);
            }

            String responseString = new String(responseStream.toByteArray());
            System.out.println(responseString);
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }

    @Override
    public Session getSession() {
        try {
            Session session = new JSch().getSession(this.userName, this.ip, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            return session;
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.glqdlt.myho.executable;

import com.glqdlt.myho.intergration.*;

public class AppMain {
    public static void main(String[] args) {

        String command = args[0];
        ConfigLoaderProperty configLoaderProperty = new ConfigLoaderProperty();
        TargetSystemWithSsh zz = configLoaderProperty.loadTarget();

        if (command.toLowerCase().equals("on")) {
            WakeOnLan wakeOnLan = new WakeOnLan();
            wakeOnLan.submit(zz::getMac);
        } else if (command.toLowerCase().equals("off")) {
            SimpleRemoteSSH simpleRemoteSSH = new SimpleRemoteSSH(zz.getUserName(), zz.getPassword(), zz.getIp());
            simpleRemoteSSH.oneTimeExecCommand(SSHCommands.SHUTDOWN);
        }

    }
}

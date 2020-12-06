package com.glqdlt.myho.intergration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoaderProperty implements ConfigLoader {

    @Override
    public TargetSystemWithSsh loadTarget() {
        String currentPath = new File(System.getProperty("java.class.path")).getParent();
        File config = new File(String.format("%s%s%s", currentPath, File.separator, "config.properties"));
        Properties props = new Properties();
        TargetSystemWithSsh targetSystem = new TargetSystemWithSsh();
        try (FileInputStream fis = new FileInputStream(config)) {
            props.load(fis);
            targetSystem.setIp(props.getProperty("target.ip"));
            targetSystem.setMac(props.getProperty("target.mac"));
            targetSystem.setName(props.getProperty("target.name"));
            targetSystem.setUserName(props.getProperty("target.ssh.username"));
            targetSystem.setPassword(props.getProperty("target.ssh.password"));
            String sshPort = props.getProperty("target.ssh.port");
            if (sshPort != null) {
                targetSystem.setPort(Integer.parseInt(sshPort));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return targetSystem;
    }
}

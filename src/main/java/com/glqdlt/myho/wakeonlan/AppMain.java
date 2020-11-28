package com.glqdlt.myho.wakeonlan;

public class AppMain {
    public static void main(String[] args) {
        WakeOnLan wakeOnLan = new WakeOnLanImpl();
        wakeOnLan.submit(args[0]);
    }
}

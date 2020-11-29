package com.glqdlt.myho.intergration;

public class AppMain {
    public static void main(String[] args) {
        WakeOnLan wakeOnLan = new WakeOnLan();
        wakeOnLan.submit(() -> args[0]);
    }
}

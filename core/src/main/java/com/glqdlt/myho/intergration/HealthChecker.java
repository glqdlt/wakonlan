package com.glqdlt.myho.intergration;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class HealthChecker {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(1);

    public void check(String targetIp, Consumer<Boolean> callback) {
        POOL.submit(() -> {
            boolean result = false;
            try {
                InetAddress inetAddress = InetAddress.getByName(targetIp);
                result = inetAddress.isReachable((int) TimeUnit.SECONDS.toMillis(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
            callback.accept(result);
        });
    }
}

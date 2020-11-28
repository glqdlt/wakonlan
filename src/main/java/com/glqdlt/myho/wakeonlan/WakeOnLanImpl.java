package com.glqdlt.myho.wakeonlan;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class WakeOnLanImpl implements WakeOnLan {

    public void submit(String targetMacAddress) {
        final String broadcast = "255.255.255.255";

        try (DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET)) {
            byte[] macBytes = getMacBytes(targetMacAddress);
            byte[] bytes = new byte[6 + 16 * macBytes.length];

            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }

            InetSocketAddress inetSocketAddress = new InetSocketAddress(broadcast, 9);
            channel.socket().setBroadcast(true);
            channel.send(ByteBuffer.wrap(bytes), inetSocketAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = macStr.split("([:\\-])");

        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }


}

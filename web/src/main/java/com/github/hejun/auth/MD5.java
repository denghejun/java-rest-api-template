package com.github.hejun.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5 {
    private MD5() {
    }

    public static String Encrypt(String content) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }

        if (messageDigest == null || content == null) {
            return null;
        }

        messageDigest.update(content.getBytes());
        byte[] bytes = messageDigest.digest();

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            hexString.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return hexString.toString().toUpperCase();
    }

}

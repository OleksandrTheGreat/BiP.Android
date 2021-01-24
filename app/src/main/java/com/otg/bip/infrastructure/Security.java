package com.otg.bip.infrastructure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Security {

    public static String md5(String string) {

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes());
            byte[] digest = md5.digest();

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                hash.append(Integer.toHexString(0xFF & digest[i]));
            }

            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}

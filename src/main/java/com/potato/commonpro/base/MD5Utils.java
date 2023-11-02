package com.potato.commonpro.base;



import java.security.MessageDigest;

public class MD5Utils {

    public static String md5(String source, String salt, boolean toUpperCase) {
        source = source + salt;

        StringBuilder sb = new StringBuilder(32);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));

            for (int i = 0; i < array.length; i++) {
                if(toUpperCase) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
                } else {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
            }
        } catch (Exception e) {
//            Log.error("Can not encode the string '" + source + "' to MD5!");
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

}

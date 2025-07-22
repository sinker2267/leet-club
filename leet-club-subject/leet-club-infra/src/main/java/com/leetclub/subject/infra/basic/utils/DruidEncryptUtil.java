package com.leetclub.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author sinker
 * @date 2025/7/18 9:18
 */

public class DruidEncryptUtil {
    private static String publicKey;
    private static String privateKey;
    static {
        try {
            String[] strings = ConfigTools.genKeyPair(512);
            privateKey = strings[0];
            System.out.println("privateKey = " + privateKey);
            publicKey = strings[1];
            System.out.println("publicKey = " + publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt = " + encrypt);
        return encrypt;
    }

    public static String dencrypt(String encryptText) throws Exception {
        String dencrypt = ConfigTools.decrypt(publicKey, encryptText);
        System.out.println("encrypt = " + dencrypt);
        return dencrypt;
    }

//    public static void main(String[] args) throws Exception {
//        String encrypt = encrypt("wuyifei1211SIN");
//        System.out.println(encrypt);
//    }
}

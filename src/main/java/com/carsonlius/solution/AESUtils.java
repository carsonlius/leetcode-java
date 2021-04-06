package com.carsonlius.solution;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES加解密工具
 */
public final class AESUtils {

    private AESUtils() {
    }

    /**
     * AES加密
     *
     * @param plainText 明文
     * @param key 密钥
     * @return byte[] 密文字节数组
     */
    public static byte[] encrypt(String plainText, String key) throws Exception {
        byte[] data = plainText.getBytes();

        //生成向量
        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        //密钥hash
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(key.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        //数据加密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(data);

        //整合向量和密文
        byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
        System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

        return encryptedIVAndText;
    }

    /**
     * AES解密
     *
     * @param encryptedIvTextBytes 明文字节数组
     * @param key 密钥
     * @return String 明文
     */
    public static String decrypt(byte[] encryptedIvTextBytes, String key) throws Exception {
        int ivSize = 16;
        int keySize = 16;

        //解析出向量内容
        byte[] iv = new byte[ivSize];
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        //解析密文数据
        int encryptedSize = encryptedIvTextBytes.length - ivSize;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize);

        //密钥hash
        byte[] keyBytes = new byte[keySize];
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(key.getBytes(StandardCharsets.UTF_8));
        System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        //密文还原
        Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

        return new String(decrypted);
    }

    public static void main(String[] args) throws Exception {
        String key = "data-key";
        String data = "深圳市南山区科技园";

//        byte[] encrypted = AESUtils.encrypt(data, key);
//        String visibleStr = Base64.getEncoder().encodeToString(encrypted);
//        System.out.println(visibleStr);

        key = "test-datakey-wdt";
        String visibleStr = "0B4mqbnbjOKVBD1YK0YzfggxcNkeKxXKtEMgT3sVwSK24fXkHrW8KBeLDRMAn6KnwZA+AosRDg18pzZTtQZayhUKFxmAtgwvxuvFSDITJxM=";


        byte[] encryptedBytes = Base64.getDecoder().decode(visibleStr);
        String decrypted = AESUtils.decrypt(encryptedBytes, key);
        System.out.println(decrypted);
    }

}

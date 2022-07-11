package com.travel.form.utils.json;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author by 李泽阳 on 2022/2/6 2:03
 * @description：
 */
public class EncryptUtil {


    private static final Logger LOG = LoggerFactory.getLogger(EncryptUtil.class.getName());

    private static final String HMAC_SHA1 = "HmacSHA1";

    private EncryptUtil() {
    }

    /**
     * md5加密
     *
     * @param inputText 文本
     * @return String
     */
    public static String md5(String inputText) {
        return encrypt(inputText, "md5");
    }

    /**
     * sha加密
     *
     * @param inputText 文本
     * @return String
     */
    public static String sha(String inputText) {
        return encrypt(inputText, "sha-1");
    }

    /**
     * 对密码加密
     *
     * @param dateTime 时间
     * @param pwd      密码
     * @return String
     */
    public static String pwd(LocalDateTime dateTime, String pwd) {
        long time = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
        return EncryptUtil.md5(pwd + time);
    }

    /**
     * 用户名加盐的方式
     *
     * @param username 账户
     * @param pwd      密码
     * @param salt     加盐
     * @return String
     */
    public static String pwd2(String username, String pwd, String salt) {
        return EncryptUtil.md5(username + pwd + salt);
    }


    /**
     * md5或者sha-1加密
     *
     * @param inputText     要加密的内容
     * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
     * @return
     */
    private static String encrypt(String inputText, String algorithmName) {
        if (inputText == null || "".equals(inputText.trim())) {
            throw new IllegalArgumentException("请输入要加密的内容");
        }
        if (StringUtils.isEmpty(algorithmName)) {
            algorithmName = "md5";
        }
        String encryptText = null;
        try {
            MessageDigest m = MessageDigest.getInstance(algorithmName);
            m.update(inputText.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            return hex(s);
        } catch (NoSuchAlgorithmException e) {
            LOG.error("加密失败", e);
        }
        return null;
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr a
     * @return String
     */
    private static String hex(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static String getSignature(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data);
        return DigestUtils.md5Hex(rawHmac);
    }
}

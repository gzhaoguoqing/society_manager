package com.sm.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Utils {
    public static String getWorkDir() {
        return System.getProperty("user.dir");
    }

    public static String getTempDir() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUploadImgRelativePath() {
        return "/upload/img/" + getUUID();
    }

    public static String getUploadFileRelativePath() {
        return "/upload/file/" + getUUID();
    }

    public static String saveUploadImg(MultipartFile img) throws IOException {
        String fileName = img.getOriginalFilename();
        String relativePath = getUploadImgRelativePath() + "/" + fileName;
        File dest = new File(getWorkDir() + relativePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        img.transferTo(dest);
        return relativePath;
    }

    public static String saveUploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String relativePath = getUploadFileRelativePath() + "/" + fileName;
        File dest = new File(getWorkDir() + relativePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return relativePath;
    }

    public static File getUploadImgAndFile(String relativePath) {
        return new File(getWorkDir() + relativePath);
    }

    /**
     * md5加密
     */
    private static String md5Enc(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /**
     * 循环多次md5加密，默认加密40次
     * @param str
     * 	要加密的字符串
     * @return
     * 	加密后的字符串
     */
    public static String md5(String str) {
        for (int i=0; i<40; i++) {
            str = md5Enc(str);
        }
        return str;
    }

    /**
     * @param str
     * 	要加密的字符串
     * @param n
     *  加密的次数
     * @return
     * 	加密后的字符串
     */
    public static String md5(String str, int n) {
        for (int i=0; i<n; i++) {
            str = md5Enc(str);
        }
        return str;
    }
}

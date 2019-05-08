package com.sm.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}

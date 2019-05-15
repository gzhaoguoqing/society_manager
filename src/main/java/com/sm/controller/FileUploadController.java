package com.sm.controller;

import com.sm.util.Utils;
import com.sm.vo.ResultEntry;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
@RequestMapping
public class FileUploadController {

    /**
     * 上传图片
     * @param img
     * @return
     */
    @PostMapping("/api/file/img")
    public ResultEntry uploadImg(MultipartFile img) {
        ResultEntry<String> result = new ResultEntry<>();
        try {
            String path = Utils.saveUploadImg(img);
            result.setData(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value="/api/file/img", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImg(String path) throws IOException {
        path = URLDecoder.decode(path, "utf-8");
        return getUploadFile(path);
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/api/file")
    public ResultEntry uploadFile(MultipartFile file) {
        ResultEntry<String> result = new ResultEntry<>();
        try {
            String path = Utils.saveUploadFile(file);
            result.setData(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value="/api/file")
    public byte[] getFile(HttpServletResponse response, String path) throws IOException {
        path = URLDecoder.decode(path, "utf-8");
        String filename = path.substring(path.lastIndexOf("/") + 1, path.length());
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
        return getUploadFile(path);
    }

    private byte[] getUploadFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(Utils.getUploadImgAndFile(path));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}

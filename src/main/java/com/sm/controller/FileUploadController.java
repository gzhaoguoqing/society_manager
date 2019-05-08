package com.sm.controller;

import com.sm.util.Utils;
import com.sm.vo.ResultEntry;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

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
    public byte[] getImg(String path) {
        try {
            path = URLDecoder.decode(path, "utf-8");
            FileInputStream inputStream = new FileInputStream(Utils.getUploadImgAndFile(path));
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}

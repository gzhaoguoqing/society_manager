package com.sm.controller;

import com.sm.bo.NoticeBO;
import com.sm.bo.UserBO;
import com.sm.po.Notice;
import com.sm.service.NoticeService;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public ResultEntry<List<NoticeBO>> list(QueryEntry qry) {
        ResultEntry<List<NoticeBO>> result = new ResultEntry<>();
        result.setTotal(noticeService.getCount());
        result.setData(noticeService.getByPage(qry));
        return result;
    }

    @GetMapping("/{id}")
    public ResultEntry<NoticeBO> getById(@PathVariable String id) {
        ResultEntry<NoticeBO> result = new ResultEntry<>();
        result.setData(noticeService.getById(id));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody Notice notice) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        notice.setId(Utils.getUUID());
        notice.setDate(new Date());
        notice.setAuthorId(loginedUser.getId());
        noticeService.add(notice);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable("ids") String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        noticeService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return new ResultEntry<>();
    }
}

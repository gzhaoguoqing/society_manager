package com.sm.controller;

import com.sm.bo.TopicBO;
import com.sm.bo.UserBO;
import com.sm.po.Topic;
import com.sm.service.TopicService;
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
@RequestMapping("/api/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResultEntry<List<TopicBO>> list(QueryEntry qry) {
        ResultEntry<List<TopicBO>> result = new ResultEntry<>();
        result.setTotal(topicService.getCount());
        result.setData(topicService.getByPage(qry));
        return result;
    }

    @GetMapping("/{id}")
    public ResultEntry<TopicBO> getById(@PathVariable String id) {
        ResultEntry<TopicBO> result = new ResultEntry<>();
        result.setData(topicService.getById(id));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody Topic topic) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        topic.setAuthorId(loginedUser.getId());
        topic.setId(Utils.getUUID());
        topic.setDate(new Date());
        topicService.add(topic);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        topicService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody Topic topic) {
        topicService.updateById(topic);
        return new ResultEntry();
    }
}

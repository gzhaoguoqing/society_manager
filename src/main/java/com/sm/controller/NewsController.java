package com.sm.controller;

import com.sm.bo.NewsBO;
import com.sm.bo.UserBO;
import com.sm.po.News;
import com.sm.service.NewsService;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResultEntry<List<NewsBO>> list(QueryEntry qry) {
        ResultEntry<List<NewsBO>> result = new ResultEntry<>();
        result.setTotal(newsService.getCount());
        result.setData(newsService.getByPage(qry));
        return result;
    }

    @GetMapping("/important")
    public ResultEntry<List<NewsBO>> important(Integer size) {
        if (size == null) {
            size = 4;
        }
        ResultEntry<List<NewsBO>> result = new ResultEntry<>();
        result.setData(newsService.getImportant(size));
        return result;
    }

    @GetMapping("/{id}")
    public ResultEntry<NewsBO> getById(@PathVariable String id) {
        ResultEntry<NewsBO> result = new ResultEntry<>();
        NewsBO newsBO = newsService.getById(id);
        result.setData(newsBO);
        News news = new News();
        news.setId(id);
        news.setClicks(newsBO.getClicks() + 1);
        newsService.updateById(news);
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody News news) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        news.setId(Utils.getUUID());
        news.setAuthorId(loginedUser.getId());
        news.setClicks(0);
        news.setDate(new Date());
        newsService.add(news);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable("ids") String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        newsService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody News news) {
        newsService.updateById(news);
        return new ResultEntry<>();
    }
}

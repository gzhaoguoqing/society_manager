package com.sm.controller;

import com.sm.bo.NewsBO;
import com.sm.po.News;
import com.sm.service.NewsService;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResultEntry<List<NewsBO>> list(QueryEntry qry) {
        ResultEntry<List<NewsBO>> result = new ResultEntry<>();
        result.setData(newsService.getByPage(qry));
        return result;
    }

    @PostMapping
    public ResultEntry add(News news) {
        newsService.add(news);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable("ids") String ids) {
        newsService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(News news) {
        newsService.updateById(news);
        return new ResultEntry<>();
    }
}

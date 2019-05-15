package com.sm.controller;

import com.sm.bo.InfoBO;
import com.sm.po.Info;
import com.sm.service.InfoService;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResultEntry<List<InfoBO>> list(QueryEntry qry) {
        ResultEntry<List<InfoBO>> result = new ResultEntry<>();
        result.setTotal(infoService.getCount());
        result.setData(infoService.getByPage(qry));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody Info info) {
        info.setId(Utils.getUUID());
        infoService.add(info);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        infoService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody Info info) {
        infoService.updateById(info);
        return new ResultEntry();
    }
}

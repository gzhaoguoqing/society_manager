package com.sm.controller;

import com.github.pagehelper.util.StringUtil;
import com.sm.bo.InfoBO;
import com.sm.bo.UserBO;
import com.sm.po.Info;
import com.sm.po.User;
import com.sm.service.InfoService;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResultEntry<List<UserBO>> list(QueryEntry qry, @RequestParam(value="infoId", required = false) String infoId) {
        ResultEntry<List<UserBO>> result = new ResultEntry<>();
        result.setTotal(userService.getCount(infoId));
        result.setData(userService.getByPage(qry, infoId));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody User user) {
        user.setId(Utils.getUUID());
        user.setPassword(Utils.md5(user.getNumber()));
        if (StringUtils.isNotBlank(user.getRoleId()) && StringUtils.isNotBlank(user.getAssociationIds())) {
            if (user.getRoleId().equals("bcd14ce4680942dc83acd9d42d4ead76")) {
                Info info = new Info();
                info.setId(user.getAssociationIds());
                info.setCharityId(user.getId());
                infoService.updateById(info);
            }
        }
        userService.add(user);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        userService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody User user) {
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(Utils.md5(user.getPassword()));
        }
        if (StringUtils.isNotBlank(user.getRoleId()) && StringUtils.isNotBlank(user.getAssociationIds())) {
            UserBO userBO = userService.getById(user.getId());
            if (userBO.getRole().getId().equals("bcd14ce4680942dc83acd9d42d4ead76")) {
                Info info = new Info();
                info.setId(userBO.getAssociations().get(0).getId());
                info.setCharityId("");
                infoService.updateById(info);
            }
            if (user.getRoleId().equals("bcd14ce4680942dc83acd9d42d4ead76")) {
                Info info = new Info();
                info.setId(user.getAssociationIds());
                info.setCharityId(user.getId());
                infoService.updateById(info);
            }
        }
        userService.updateById(user);
        return new ResultEntry();
    }

    @PutMapping("/{ids}")
    public ResultEntry resetPwd(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        userService.resetPwd(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @GetMapping("/export")
    public byte[] export(HttpServletResponse response, @RequestParam(value="infoId", required = false) String infoId) throws IOException {
        String[] header = new String[] {"学号/工号", "姓名", "性别", "班级", "联系方式", "角色", "社团"};
        if (infoId != null) {
            header = new String[] {"学号/工号", "姓名", "性别", "班级", "联系方式", "角色"};
        }
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(header);
        File file = new File(Utils.getTempDir() + "/export/成员信息.csv");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        List<UserBO> users = userService.getByPage(null, infoId);
        for (UserBO user : users) {
            ArrayList<String> record = new ArrayList<>();
            record.add(user.getNumber());
            record.add(user.getName());
            record.add(user.getSex()==0 ? "男" : "女");
            record.add(user.getClasses());
            record.add(user.getContactWay());
            record.add(user.getRole().getName());
            if (infoId == null) {
                List<InfoBO> associations = user.getAssociations();
                List<String> associationIds = new ArrayList<>();
                for (InfoBO infoBO : associations) {
                    associationIds.add(infoBO.getName());
                }
                record.add(StringUtils.join(associationIds, ","));
            }
            csvPrinter.printRecord(record);
        }
        csvPrinter.flush();
        fileWriter.close();
        csvPrinter.close();

        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(file.getName(), "utf-8"));
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}

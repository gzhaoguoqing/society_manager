package com.sm.controller;

import com.sm.bo.PostBO;
import com.sm.bo.TopicBO;
import com.sm.bo.UserBO;
import com.sm.po.Comment;
import com.sm.po.Post;
import com.sm.po.Topic;
import com.sm.po.Up;
import com.sm.service.CommentService;
import com.sm.service.PostService;
import com.sm.service.TopicService;
import com.sm.service.UpService;
import com.sm.util.Utils;
import com.sm.vo.PostQuery;
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
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UpService upService;

    @GetMapping
    public ResultEntry<List<PostBO>> list(PostQuery qry) {
        ResultEntry<List<PostBO>> result = new ResultEntry<>();
        result.setTotal(postService.getCount(qry.getTopicId()));
        result.setData(postService.getByPage(qry));
        return result;
    }

    @GetMapping("/{id}")
    public ResultEntry<PostBO> getById(@PathVariable String id) {
        ResultEntry<PostBO> result = new ResultEntry<>();
        result.setData(postService.getById(id));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody Post post) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        post.setId(Utils.getUUID());
        post.setAuthorId(loginedUser.getId());
        post.setDate(new Date());
        postService.add(post);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        postService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody Post post) {
        postService.updateById(post);
        return new ResultEntry();
    }

    @PostMapping("/comment")
    public ResultEntry addComment(@RequestBody Comment comment) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        comment.setId(Utils.getUUID());
        comment.setAuthorId(loginedUser.getId());
        comment.setDate(new Date());
        commentService.add(comment);
        return new ResultEntry();
    }

    @PostMapping("/up")
    public ResultEntry addUp(@RequestBody Up up) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        up.setAuthorId(loginedUser.getId());
        if (!upService.existUp(up)) {
            upService.add(up);
        }
        return new ResultEntry();
    }
}

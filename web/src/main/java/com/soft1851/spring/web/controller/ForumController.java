package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName ForumController
 * @Description TODO
 * @date 2020-03-20 11:30
 **/
@RestController
@RequestMapping(value = "forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String getForums(){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @PostMapping(value = "/insert",produces = "application/json;charset=utf-8")
    public String insertForum(@Validated Forum forum){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.insert(forum));
        return JSON.toJSONString(ro);
    }

    @PostMapping(value = "/select",produces = "application/json;charset=utf-8")
    public String selectById(@RequestParam Integer forumId){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectById(forumId));
        return JSON.toJSONString(ro);
    }
    @DeleteMapping(value = "/delete/{forumId}",produces = "application/json;charset=utf-8")
    public String deleteById(@PathVariable Integer forumId){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.deleteById(forumId));
        return JSON.toJSONString(ro);
    }
    @PostMapping(value = "/update", produces = "application/json;charset=utf-8")
    public String updateForums(@Validated Forum forum){
        System.out.println(forum);
        ResponseObject ro = new ResponseObject(1,"成功",forumService.update(forum));
        return JSON.toJSONString(ro);
    }
    @DeleteMapping(value = "/del/{forumId}", produces = "application/json;charset=utf-8")
    public String bathDelForum(@PathVariable String forumId) {
        ResponseObject ro = new ResponseObject(3, "成功", forumService.batchDelete(forumId));
        return JSON.toJSONString(ro);
    }

}

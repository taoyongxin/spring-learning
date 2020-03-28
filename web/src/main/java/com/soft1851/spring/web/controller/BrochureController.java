package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Brochure;
import com.soft1851.spring.web.service.BrochureService;
import com.soft1851.spring.web.spider.JueJinXiaoCeSpider;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tao
 */
@Controller
@RequestMapping(value = "/")
public class BrochureController {
    @Resource
    private BrochureService brochureService;

    @GetMapping(value = "brochures", produces="application/json; charset=utf-8")
    @ResponseBody
    public String getBrochures(){
        ResponseObject rs=new ResponseObject(1,"success",brochureService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("brochure")
    public String brochure(Model model){
        List<Brochure> brochureList=JueJinXiaoCeSpider.getBrochure(1);
        model.addAttribute("brochureList",brochureList);
        return "brochure";
    }
}

package com.potato.commonpro.controller;


import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.model.RWebsite;
import com.potato.commonpro.model.SDict;
import com.potato.commonpro.service.RWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RWebsiteController {

    @Autowired
    RWebsiteService websiteService;


    @RequestMapping("/admin/rwebsite/list")
    @ResponseBody
    public JsonResult list(@RequestBody RWebsite website){
        return JsonResult.success(websiteService.list(website));
    }

    @RequestMapping("/admin/rwebsite/add")
    @ResponseBody
    public JsonResult add(@RequestBody  RWebsite website){
        websiteService.add(website);
        return JsonResult.success();
    }

    @RequestMapping("/admin/rwebsite/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody RWebsite website){
        websiteService.modify(website);
        return JsonResult.success();
    }

    @RequestMapping("/admin/rwebsite/del")
    @ResponseBody
    public JsonResult del(@RequestBody RWebsite website){
        websiteService.del(website);
        return JsonResult.success();
    }

}

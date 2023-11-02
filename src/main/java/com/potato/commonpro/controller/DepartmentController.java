package com.potato.commonpro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.base.valid.AddGroup;
import com.potato.commonpro.base.valid.ModifyGroup;
import com.potato.commonpro.model.CLResult;
import com.potato.commonpro.model.Department;
import com.potato.commonpro.service.DepartmentService;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/admin/dept/list")
    @ResponseBody
    public JsonResult list(@RequestBody(required = false) Department department){
        return JsonResult.success(departmentService.list(department));
    }

    @RequestMapping("/admin/dept/add")
    @ResponseBody
    public JsonResult add(@RequestBody @Validated({AddGroup.class}) Department department){
        departmentService.add(department);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dept/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody @Validated({ModifyGroup.class}) Department department){
        departmentService.modify(department);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dept/del")
    @ResponseBody
    public JsonResult del(@RequestBody @Validated({ModifyGroup.class}) Department department){
        departmentService.del(department);
        return JsonResult.success();
    }



}

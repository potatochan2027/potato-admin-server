package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.base.valid.AddGroup;
import com.potato.commonpro.base.valid.ModifyGroup;
import com.potato.commonpro.model.Department;
import com.potato.commonpro.model.SDict;
import com.potato.commonpro.model.SDictKey;
import com.potato.commonpro.service.SDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SDictController {


    @Autowired
    SDictService sDictService;

    @RequestMapping("/admin/dict/list")
    @ResponseBody
    public JsonResult list(@RequestBody SDict sDict){
        return JsonResult.success(sDictService.list(sDict));
    }

    @RequestMapping("/admin/dict/add")
    @ResponseBody
    public JsonResult add(@RequestBody  SDict sDict){
        sDictService.add(sDict);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dict/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody SDict sDict){
        sDictService.modify(sDict);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dict/del")
    @ResponseBody
    public JsonResult del(@RequestBody SDict sDict){
        sDictService.del(sDict);
        return JsonResult.success();
    }



    @RequestMapping("/admin/dict/listKey")
    @ResponseBody
    public JsonResult listKey(@RequestBody SDict sDict){
        return JsonResult.success(sDictService.listKey(sDict.getId()));
    }

    @RequestMapping("/admin/dict/getKey")
    @ResponseBody
    public JsonResult getKey(@RequestBody SDict sDict){
        return JsonResult.success(sDictService.get(sDict.getName()));
    }


    @RequestMapping("/admin/dict/addKey")
    @ResponseBody
    public JsonResult addKey(@RequestBody SDictKey sDictKey){
        sDictService.add(sDictKey);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dict/modifyKey")
    @ResponseBody
    public JsonResult modifyKey(@RequestBody SDictKey sDictKey){
        sDictService.modify(sDictKey);
        return JsonResult.success();
    }

    @RequestMapping("/admin/dict/delKey")
    @ResponseBody
    public JsonResult delKey(@RequestBody SDictKey sDictKey){
        sDictService.del(sDictKey);
        return JsonResult.success();
    }

}

package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import com.potato.commonpro.service.RouterMetaService;
import com.potato.commonpro.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RouterMetaController {

    @Autowired
    RouterMetaService routerMetaService;

    @RequestMapping("/admin/menu/meta/list")
    @ResponseBody
    public JsonResult list(@RequestBody RouterMeta routerMeta){
        return  JsonResult.success(routerMetaService.list(routerMeta));
    }

    @RequestMapping("/admin/menu/meta/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody RouterMeta routerMeta){
        routerMetaService.modify(routerMeta);
        return  JsonResult.success();
    }

}

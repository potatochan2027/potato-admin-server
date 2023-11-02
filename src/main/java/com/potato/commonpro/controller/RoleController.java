package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import com.potato.commonpro.model.vo.UserRoleVO;
import com.potato.commonpro.service.RoleService;
import com.potato.commonpro.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/admin/role/list")
    @ResponseBody
    public JsonResult list(@RequestBody(required = false) Role role) {
        return JsonResult.success(roleService.list(role));
    }

    @RequestMapping("/admin/role/listById")
    @ResponseBody
    public JsonResult listById(@RequestBody SUser sUser) {
        return JsonResult.success(roleService.listByUId(sUser.getId()));
    }

    /**
     * 为后台用户绑定角色
     * @return
     */
    @RequestMapping("/admin/role/bind")
    @ResponseBody
    public JsonResult bind(@RequestBody UserRoleVO vo) {
        roleService.bind(vo.getUid(),vo.getIds());
        return JsonResult.success();
    }


    @RequestMapping("/admin/role/add")
    @ResponseBody
    public JsonResult add(@RequestBody Role role) {
        roleService.add(role);
        return JsonResult.success();
    }

    @RequestMapping("/admin/role/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody Role role) {
        roleService.modify(role);
        return JsonResult.success();
    }

    @RequestMapping("/admin/role/del")
    @ResponseBody
    public JsonResult del(@RequestBody Role role) {
        roleService.del(role);
        return JsonResult.success();
    }


}

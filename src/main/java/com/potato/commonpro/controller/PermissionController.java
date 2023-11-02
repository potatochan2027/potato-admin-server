package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.base.valid.OtherGroup;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import com.potato.commonpro.model.SUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PermissionController {


    @RequestMapping("/getAsyncRoutes")
    @ResponseBody
    public JsonResult getAsyncRoutes(){

        List<Router> routers=new ArrayList<>();

        Router router=new Router();
        router.setPath("/permission1");
        RouterMeta routerMeta=new RouterMeta();
        routerMeta.setTitle("权限");
        routerMeta.setIcon("lollipop");
        routerMeta.setRank(10);
        router.setMeta(routerMeta);
        
        List<Router> routerList=new ArrayList<>();

        Router router1=new Router();
        router1.setPath("/permission/page/index1");
        router1.setName("PermissionPage1");
        RouterMeta meta1=new RouterMeta();
        meta1.setTitle("页面");
        List<String> roles=new ArrayList<>();
        roles.add("admin");
        roles.add("common");
        meta1.setRoles(roles);
        router1.setMeta(meta1);
        routerList.add(router1);

        Router router2=new Router();
        router2.setPath("/permission/button/index1");
        router2.setName("PermissionButton1");
        RouterMeta meta2=new RouterMeta();
        meta2.setTitle("按钮");
        meta2.setRoles(roles);
        List<String> auths=new ArrayList<>();
        auths.add("btn_add");
        auths.add("btn_add");
        auths.add("btn_delete");
        meta2.setAuths(auths);
        router2.setMeta(meta2);
        routerList.add(router2);


        router.setChildren(routerList);

        Router router3=new Router();
        router3.setPath("/platform");
        RouterMeta routerMeta3=new RouterMeta();
        routerMeta3.setTitle("平台管理");
        routerMeta3.setIcon("lollipop");
        routerMeta3.setRank(10);
        router3.setMeta(routerMeta3);

        List<Router> routerList2=new ArrayList<>();

        Router router4=new Router();
        router4.setPath("/platform/role");
        router4.setName("role");
        RouterMeta routerMeta4=new RouterMeta();
        routerMeta4.setTitle("角色管理");
        routerMeta4.setIcon("lollipop");
        router4.setComponent("views/system/role/index.vue");
        routerMeta4.setRank(10);
        routerMeta4.setRoles(roles);
        router4.setMeta(routerMeta4);

        Router router5=new Router();
        router5.setPath("/platform/menu");
        router5.setName("menu");
        router5.setComponent("views/system/menu/index.vue");
        RouterMeta routerMeta5=new RouterMeta();
        routerMeta5.setTitle("菜单管理");
        routerMeta5.setIcon("lollipop");
        routerMeta5.setRank(10);
        routerMeta5.setRoles(roles);
        router5.setMeta(routerMeta5);


        Router router7=new Router();
        router7.setPath("/platform/dept");
        router7.setName("suer");
        router7.setComponent("views/system/dept/index.vue");
        RouterMeta routerMeta7=new RouterMeta();
        routerMeta7.setTitle("部门管理");
        routerMeta7.setIcon("lollipop");
        routerMeta7.setRank(10);
        routerMeta7.setRoles(roles);
        router7.setMeta(routerMeta7);

        Router router8=new Router();
        router8.setPath("/platform/auser");
        router8.setName("auser");
        router8.setComponent("views/system/auser/index.vue");
        RouterMeta routerMeta8=new RouterMeta();
        routerMeta8.setTitle("后台用户");
        routerMeta8.setIcon("lollipop");
        routerMeta8.setRank(10);
        routerMeta8.setRoles(roles);
        router8.setMeta(routerMeta8);


        routerList2.add(router4);
        routerList2.add(router5);
        routerList2.add(router7);
        routerList2.add(router8);
        router3.setChildren(routerList2);


        routers.add(router);
        routers.add(router3);

        return JsonResult.success(routers);
    }


}

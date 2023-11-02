package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.dao.RoleRouterDao;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import com.potato.commonpro.model.vo.RoleRouterVO;
import com.potato.commonpro.model.vo.UserRoleVO;
import com.potato.commonpro.service.RoleService;
import com.potato.commonpro.service.RouterMetaService;
import com.potato.commonpro.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RouterController {

    @Autowired
    RouterService routerService;

    @Autowired
    RouterMetaService routerMetaService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRouterDao roleRouterDao;

    @RequestMapping("/admin/menu/list")
    @ResponseBody
    public JsonResult list(@RequestBody Router router) {
        List<Router> routerList = routerService.list(router);
        return JsonResult.success(routerList);
    }

    @RequestMapping("/admin/menu/listByRoleId")
    @ResponseBody
    public JsonResult listByRoleId(@RequestBody Role role) {
        return JsonResult.success(routerService.listByRoleId(role.getId()));
    }

    @RequestMapping("/admin/menu/add")
    @ResponseBody
    public JsonResult add(@RequestBody Router router) {
        if (router.getParentId() == 0) {
            router.setParentId(-1);
        }
        routerService.add(router);
        return JsonResult.success();
    }

    @RequestMapping("/admin/menu/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody Router router) {
        routerService.modify(router);
        return JsonResult.success();
    }

    @RequestMapping("/admin/menu/del")
    @ResponseBody
    public JsonResult del(@RequestBody Router router) {
        routerService.del(router);
        return JsonResult.success();
    }


    @RequestMapping("/admin/menu/bind")
    @ResponseBody
    public JsonResult bind(@RequestBody RoleRouterVO vo) {
        routerService.bind(vo.getRoleId(), vo.getRouterList());
        return JsonResult.success();
    }


    @RequestMapping("/admin/menu/getAsyncRoutes")
    @ResponseBody
    public JsonResult getAsyncRoutes() {

        //获取所有菜单
        List<Router> routerList = routerService.list(new Router());

        List<Router> tree = new ArrayList<>();
        List<Router> treeChildren = new ArrayList<>();
        //通过递归算法，转化成树

        //加入第一层菜单
        for (Router router : routerList) {
            if (router.getId() == -1) {
                //虚拟根目录ROOT
                continue;
            }
            if (router.getParentId() == -1) {
                tree.add(router);
            } else {
                treeChildren.add(router);
            }
        }

        //二级菜单
        List<Router> subTree = new ArrayList<>();
        if (!treeChildren.isEmpty()) {
            for (Router router : treeChildren) {
                boolean flag = true;
                for (Router item : tree) {
                    if (item.getId() == router.getParentId()) {
                        if (item.getChildren() == null) {
                            item.setChildren(new ArrayList<Router>());
                        }

                        router.getMeta().setRoles(roleRouterDao.listByRouterId(router.getId()));
                        ;

                        item.getChildren().add(router);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    subTree.add(router);
                }
            }
        }

        //三级菜单
        if (!subTree.isEmpty()) {
            for (Router router : subTree) {
                for (Router item : tree) {
                    if (item.getChildren() == null) {
                        break;
                    }
                    for (Router subItem : item.getChildren()) {
                        if (subItem.getId() == router.getParentId()) {
                            if (subItem.getChildren() == null) {
                                subItem.setChildren(new ArrayList<Router>());
                            }
                            router.getMeta().setRoles(roleRouterDao.listByRouterId(router.getId()));
                            ;
                            subItem.getChildren().add(router);
                        }
                    }
                }
            }
        }


        //获取菜单对应的角色

        return JsonResult.success(tree);
    }

    public boolean dg(List<Router> routerList, Router router) {
        if (routerList == null) {
            return false;
        }
        if (routerList.isEmpty()) {
            return false;
        }

        for (Router item : routerList) {
            if (item.getId() == router.getParentId()) {
                if (item.getChildren() == null) {
                    item.setChildren(new ArrayList<>());
                }
                item.getChildren().add(router);
                return true;
            } else {
                return dg(item.getChildren(), router);
            }
        }
        return false;
    }


}

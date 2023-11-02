package com.potato.commonpro.controller;

import com.potato.commonpro.base.GlobalException;
import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.base.MD5Utils;
import com.potato.commonpro.base.valid.OtherGroup;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import com.potato.commonpro.service.RoleService;
import com.potato.commonpro.service.SUserService;
import com.potato.commonpro.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SUserController {

    @Autowired
    private SUserService sUserService;

    @Autowired
    private RoleService roleService;

    /**
     * 登录接口
     *
     * @param sUser
     * @return
     */
    @RequestMapping("/admin/login")
    @ResponseBody
    public JsonResult login(@RequestBody @Validated({OtherGroup.class}) SUser sUser) {
        //根据用户名获取该用户对象
        SUser realUser = sUserService.getByUsername(sUser.getUsername());
        //获取该用户密码的MD5，判断密码是否正确
        String md5Password = MD5Utils.md5(sUser.getUsername(), "common", false);

        //对比密码
        if (md5Password.equals(realUser.getPassword())) {
            //密码正确

            //生成授权Token
            String accessToken = MD5Utils.md5(sUser.getUsername(), new Date().getTime() + "", false);
            String refreshToken = MD5Utils.md5(sUser.getUsername(), new Date().getTime() + "", false);

            //保存到数据库
            realUser.setAccessToken(accessToken);
            realUser.setRefreshToken(refreshToken);
            realUser.setExpires(DateUtil.getDateAfterNHour(2));
            sUserService.modify(realUser);

            //清除密码，防止泄露
            realUser.setPassword(null);

            //获取用户的角色列表
            List<Role> roles = roleService.listByUId(realUser.getId());
            List<String> rolesStrList=new ArrayList<>();

            for(Role role:roles){
                rolesStrList.add(role.getMark());
            }

            realUser.setRoles(rolesStrList);

            return JsonResult.success(realUser);
        } else {
            //密码错误
            return JsonResult.error(-1, "密码错误");
        }
    }

    @RequestMapping("/admin/refreshToken")
    @ResponseBody
    public JsonResult refreshToken(@RequestBody SUser sUser) {

        SUser resultUser = sUserService.refreshToken(sUser);

        if (resultUser != null) {
            return JsonResult.success(resultUser);
        } else {
            return JsonResult.error(-1, "refreshToken错误");
        }

    }


    /**
     * 获取用户列表，分页功能由前端实现
     *
     * @return
     */
    @RequestMapping("/admin/user/list")
    @ResponseBody
    public JsonResult list(@RequestBody SUser sUser) {
        return JsonResult.success(sUserService.list(sUser));
    }

    @RequestMapping("/admin/user/add")
    @ResponseBody
    public JsonResult add(SUser sUser) {
        sUserService.add(sUser);
        return JsonResult.success();
    }

    /**
     * 修改用户，根据用户ID来进行更新，全量更新
     *
     * @param sUser
     * @return
     */
    @RequestMapping("/admin/user/modify")
    @ResponseBody
    public JsonResult modify(@RequestBody SUser sUser) {
        sUserService.modify(sUser);
        return JsonResult.success();
    }

    /**
     * 需要前端提前提示。该用户相关联的内容都会被删除，除了日志
     *
     * @param sUser
     * @return
     */
    @RequestMapping("/admin/user/del")
    @ResponseBody
    public JsonResult del(@RequestBody SUser sUser) {
        sUserService.del(sUser);
        return JsonResult.success();
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @RequestMapping("/admin/user/batchDel")
    @ResponseBody
    public JsonResult batchDel(@RequestParam(name = "idList[]") int[] idList) {

        for (int id : idList) {
            SUser sUser = new SUser();
            sUser.setId(id);
            sUserService.del(sUser);
        }
        return JsonResult.success();
    }


}

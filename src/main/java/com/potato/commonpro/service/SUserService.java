package com.potato.commonpro.service;

import com.potato.commonpro.base.MD5Utils;
import com.potato.commonpro.base.Page;
import com.potato.commonpro.dao.SUserDao;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import com.potato.commonpro.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SUserService {

    @Autowired
    private SUserDao sUserDao;

    public Page<SUser> list(SUser sUser) {
        Page<SUser> page = new Page<>();
        page.setList(sUserDao.list(sUser));
        page.setTotal(sUserDao.count(sUser));
        page.setPageSize(sUser.getPageSize());
        page.setCurrentPage(sUser.getCurrentPage());

        return page;
    }

    /**
     * 添加后台用户
     *
     * @param sUser
     */
    public void add(SUser sUser) {
        //对明文密码进行加密
        String md5Password = MD5Utils.md5(sUser.getUsername(), "common", false);
        sUser.setPassword(md5Password);
        //存入数据库
        sUserDao.add(sUser);
    }

    public void modify(SUser sUser) {
        sUserDao.modify(sUser);
    }

    public void del(SUser sUser) {
        sUserDao.del(sUser);
    }

    public String getPassword(String username) {
        return sUserDao.getPassword(username);
    }

    /**
     * 根据ID获取后台用户对象
     */
    public SUser getById(int id) {
        return sUserDao.getById(id);
    }

    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     */
    public SUser getByUsername(String username) {
        return sUserDao.getByUsername(username);
    }

    public SUser refreshToken(SUser sUser) {

        SUser realUser = sUserDao.getByRefreshToken(sUser.getRefreshToken());

        //刷新Token对比成功
        if (sUser.getRefreshToken().equals(realUser.getRefreshToken())) {
            //生成授权Token
            String accessToken = MD5Utils.md5(realUser.getUsername(), new Date().getTime() + "", false);
            String refreshToken = MD5Utils.md5(realUser.getUsername(), new Date().getTime() + "", false);

            //保存到数据库
            realUser.setAccessToken(accessToken);
            realUser.setRefreshToken(refreshToken);
            realUser.setExpires(DateUtil.getDateAfterNHour(2));
            sUserDao.modify(realUser);
            realUser.setPassword(null);
        } else {
            return null;
        }
        return realUser;
    }
}

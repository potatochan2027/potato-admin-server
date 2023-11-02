package com.potato.commonpro.dao;

import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SUserDao {

    /**
     * 获取后台用户列表
     * @return
     */
     List<SUser> list(SUser sUser);

    /**
     * 根据用户名获取已加密的密码
     * @param username
     * @return
     */
     String getPassword(String username);

    /**
     * 添加后台用户
     * @param sUser
     */
     void add(SUser sUser);

    int count(SUser sUser);

     SUser getById(int id);

     SUser getByUsername(@Param("username") String username);

     void modify(SUser sUser);

    void del(SUser sUser);

     SUser getByRefreshToken(@Param("refreshToken") String refreshToken);

}

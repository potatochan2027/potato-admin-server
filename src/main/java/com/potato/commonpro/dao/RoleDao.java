package com.potato.commonpro.dao;

import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import com.potato.commonpro.model.ro.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {

    List<Role> list(Role role);

    List<Role> listByUId(@Param("id") int id);

    List<UserRole> listUserRole(@Param("suid") int suid);

    int count(Role role);

    void add(Role role);

    void bind(UserRole userRole);

    void modify(Role role);

    void del(Role role);

    void delBind(UserRole userRole);
}

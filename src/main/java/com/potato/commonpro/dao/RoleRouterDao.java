package com.potato.commonpro.dao;

import com.potato.commonpro.model.ro.RoleRouter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleRouterDao {


    List<RoleRouter> list(@Param("roleId") int roleId);


    List<String> listByRouterId(@Param("routerId") int routerId);

    void del(@Param("id") int id);

    void add(@Param("roleId") int roleId,@Param("routerId") int routerId);



}

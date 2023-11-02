package com.potato.commonpro.dao;

import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.ro.RoleRouter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RouterDao {

    List<Router> list(Router router);

    Router getById(Router router);

    void add(Router router);

    void modify(Router router);

    void del(Router router);

}

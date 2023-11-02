package com.potato.commonpro.dao;

import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RouterMetaDao {

    List<RouterMeta> list(RouterMeta routerMeta);
    RouterMeta getById(@Param("id") int id);

    int add(RouterMeta routerMeta);

    void modify(RouterMeta routerMeta);

    void del(RouterMeta routerMeta);
    void delById(@Param("id") int id);


}

package com.potato.commonpro.dao;


import com.potato.commonpro.model.RWebsite;
import com.potato.commonpro.model.SDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RWebsiteDao {

    List<RWebsite> list(RWebsite website);

    int count(RWebsite website);

    void add(RWebsite website);

    void modify(RWebsite website);

    void del(RWebsite website);

}

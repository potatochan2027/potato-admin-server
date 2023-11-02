package com.potato.commonpro.dao;


import com.potato.commonpro.model.SDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SDictDao {

    List<SDict> list(SDict dict);

    int count(SDict dict);

    void add(SDict dict);

    void modify(SDict dict);

    void del(SDict dict);

}

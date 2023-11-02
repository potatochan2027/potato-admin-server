package com.potato.commonpro.dao;


import com.potato.commonpro.model.SDict;
import com.potato.commonpro.model.SDictKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SDictKeyDao {

    List<SDictKey> list(@Param("dictId") Integer dictId);

    /**
     * 根据字典名，获取key-value列表
     * @param dictName
     * @return
     */
    List<SDictKey> get(@Param("dictName") String dictName);



    void add(SDictKey dict);

    void modify(SDictKey dict);

    void del(SDictKey dict);

}

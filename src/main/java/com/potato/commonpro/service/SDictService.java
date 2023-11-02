package com.potato.commonpro.service;

import com.potato.commonpro.base.Page;
import com.potato.commonpro.dao.SDictDao;
import com.potato.commonpro.dao.SDictKeyDao;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SDict;
import com.potato.commonpro.model.SDictKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SDictService {

    @Autowired
    SDictDao sDictDao;

    @Autowired
    SDictKeyDao sDictKeyDao;

    public Page<SDict> list(SDict sDict){
        Page<SDict> page = new Page<>();
        page.setList(sDictDao.list(sDict));
        page.setTotal(sDictDao.count(sDict));
        page.setPageSize(sDict.getPageSize());
        page.setCurrentPage(sDict.getCurrentPage());
        return page;
    }

    public void add(SDict sDict){
        sDictDao.add(sDict);
    }

    public void modify(SDict sDict){
        sDictDao.modify(sDict);
    }

    public void del(SDict sDict){
        sDictDao.del(sDict);
    }

    /**
     * 根据字典id 获取对应key-value
     * @param dictId
     * @return
     */
    public List<SDictKey> listKey(Integer dictId){
        return sDictKeyDao.list(dictId);
    }

    public List<SDictKey> get(String dictName){
        return sDictKeyDao.get(dictName);
    }

    public void add(SDictKey sDictKey){
        sDictKeyDao.add(sDictKey);
    }

    public void modify(SDictKey sDictKey){
        sDictKeyDao.modify(sDictKey);
    }

    public void del(SDictKey sDictKey){
        sDictKeyDao.del(sDictKey);
    }


}

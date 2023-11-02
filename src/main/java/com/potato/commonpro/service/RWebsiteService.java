package com.potato.commonpro.service;

import com.potato.commonpro.base.Page;
import com.potato.commonpro.dao.RWebsiteDao;
import com.potato.commonpro.model.RWebsite;
import com.potato.commonpro.model.SDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RWebsiteService {

    @Autowired
    RWebsiteDao websiteDao;

    public Page<RWebsite> list(RWebsite website){
        Page<RWebsite> page = new Page<>();
        page.setList(websiteDao.list(website));
        page.setTotal(websiteDao.count(website));
        page.setPageSize(website.getPageSize());
        page.setCurrentPage(website.getCurrentPage());
        return page;
    }

    public void add(RWebsite website){
        websiteDao.add(website);
    }

    public void modify(RWebsite website){
        websiteDao.modify(website);
    }

    public void del(RWebsite website){
        websiteDao.del(website);
    }
}

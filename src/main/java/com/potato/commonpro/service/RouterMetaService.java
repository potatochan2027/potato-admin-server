package com.potato.commonpro.service;

import com.potato.commonpro.dao.RouterDao;
import com.potato.commonpro.dao.RouterMetaDao;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterMetaService {

    @Autowired
    RouterMetaDao routerMetaDao;

    public List<RouterMeta> list(RouterMeta routerMeta) {
        return routerMetaDao.list(routerMeta);
    }

    public void add(RouterMeta routerMeta) {
        routerMetaDao.add(routerMeta);
    }

    public void modify(RouterMeta routerMeta) {
        routerMeta.setSort(routerMeta.getRank());
        routerMetaDao.modify(routerMeta);
    }

    public void del(RouterMeta routerMeta) {
        routerMetaDao.del(routerMeta);
    }

}

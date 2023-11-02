package com.potato.commonpro.service;

import com.potato.commonpro.dao.RoleRouterDao;
import com.potato.commonpro.dao.RouterDao;
import com.potato.commonpro.dao.RouterMetaDao;
import com.potato.commonpro.model.Router;
import com.potato.commonpro.model.RouterMeta;
import com.potato.commonpro.model.ro.RoleRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouterService {

    @Autowired
    RouterDao routerDao;

    @Autowired
    RoleRouterDao roleRouterDao;

    @Autowired
    RouterMetaDao routerMetaDao;

    public List<Router> list(Router router) {
        List<Router> routerList = routerDao.list(router);
        for (Router r : routerList) {
            RouterMeta routerMeta = routerMetaDao.getById(r.getMetaId());
            routerMeta.setRank(routerMeta.getSort());
            r.setMeta(routerMeta);
        }
        return routerList;
    }

    public List<RoleRouter> listByRoleId(int roleId){
        return roleRouterDao.list(roleId);
    }

    public void add(Router router) {
        //每个Router都对应有一个RouterMeta
        RouterMeta routerMeta = new RouterMeta();
        routerMeta.setTitle(router.getName());
        routerMeta.setSort(11);
        routerMeta.setIcon("lollipop");
        routerMetaDao.add(routerMeta);

        List<RouterMeta> routerMetaList = routerMetaDao.list(routerMeta);
        router.setMetaId(routerMetaList.get(0).getId());

        routerDao.add(router);
    }

    public void modify(Router router) {
        routerDao.modify(router);
    }

    public void del(Router router) {
        Router temp = routerDao.getById(router);
        routerDao.del(router);
        routerMetaDao.delById(temp.getMetaId());
    }

    public void bind(int roleId, List<Integer> routerIdList) {
        List<RoleRouter> roleRouterList = roleRouterDao.list(roleId);
        //请求有且数据库没有的-》新增
        for(Integer routerId:routerIdList){
            boolean flag = true;
            for (RoleRouter roleRouter : roleRouterList) {
                if(routerId==roleRouter.getRouterId()){
                    flag=false;
                }
            }

            if(flag){
                roleRouterDao.add(roleId,routerId);
            }
        }
        //请求没有 且 数据库有的 -》删除
        for (RoleRouter roleRouter : roleRouterList) {
            boolean flag = true;
            for(Integer routerId:routerIdList){
                if(roleRouter.getRouterId()==routerId){
                    flag=false;
                }
            }
            if(flag){
                roleRouterDao.del(roleRouter.getId());
            }
        }
    }

}

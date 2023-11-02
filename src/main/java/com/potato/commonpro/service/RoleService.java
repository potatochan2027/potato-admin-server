package com.potato.commonpro.service;

import com.potato.commonpro.base.Page;
import com.potato.commonpro.dao.RoleDao;
import com.potato.commonpro.model.Role;
import com.potato.commonpro.model.SUser;
import com.potato.commonpro.model.ro.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public Page<Role> list(Role role) {
        Page<Role> rolePage = new Page<>();
        rolePage.setList(roleDao.list(role));
        rolePage.setTotal(roleDao.count(role));
        rolePage.setPageSize(role.getPageSize());
        rolePage.setCurrentPage(role.getCurrentPage());
        return rolePage;
    }

    public List<Role> listByUId(int uid) {
        return roleDao.listByUId(uid);
    }

    public void bind(int uid, List<Role> roleIdList) {
        List<UserRole> userRoles = roleDao.listUserRole(uid);

        for (Role role : roleIdList) {
            boolean flag=true;
            for(UserRole userRole:userRoles){
                if(userRole.getRid()==role.getId()){
                    flag=false;
                }
            }
            if(flag){
                roleDao.bind(new UserRole(uid,role.getId()));
            }
        }

        for (UserRole userRole : userRoles) {
            boolean flag=true;
            for(Role role : roleIdList){
                if(userRole.getRid()==role.getId()){
                    flag=false;
                }
            }
            if(flag){
                roleDao.delBind(userRole);
            }
        }



    }


    public void add(Role role) {
        if (role.getStatus() == 0) {
            role.setStatus(1);
        }
        roleDao.add(role);
    }

    public void modify(Role role) {
        roleDao.modify(role);
    }

    public void del(Role role) {
        roleDao.del(role);
    }


}

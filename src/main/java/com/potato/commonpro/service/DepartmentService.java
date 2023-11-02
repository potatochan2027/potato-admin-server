package com.potato.commonpro.service;


import com.potato.commonpro.dao.DepartmentDao;
import com.potato.commonpro.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 根据筛选条件筛选部门，返回列表
     * @param department
     * @return
     */
     public List<Department> list(Department department){
        return departmentDao.list(department);
    }

    /**
     * 新增部门
     * @param department
     */
    public void add(Department department){
        if(department.getStatus()==0){
            department.setStatus(1);
        }
        departmentDao.add(department);
    }

    /**
     * 编辑部门
     * @param department
     */
    public void modify(Department department){
        departmentDao.modify(department);
    }

    /**
     * 删除部门
     * @param department
     */
    public void del(Department department){
        departmentDao.del(department);
    }


}

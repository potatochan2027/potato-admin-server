package com.potato.commonpro.dao;

import com.potato.commonpro.model.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    List<Department> list(Department department);

    void add(Department department);

    void modify(Department department);

    void del(Department department);

}

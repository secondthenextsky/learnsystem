package com.learnsystem.dao;


import com.learnsystem.bean.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerDao {
    public int add(Manager manager);
    public int delete(@Param("id")String id);
    public int update(Manager manager);
    public List<Manager> get(Manager manager);
}

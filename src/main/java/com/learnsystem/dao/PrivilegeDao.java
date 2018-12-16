package com.learnsystem.dao;


import com.learnsystem.bean.Privilege;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegeDao {
    public int add(Privilege privilege);
    public int delete(@Param("id") int id);
    public int update(Privilege privilege);
    public List<Privilege> get(Privilege privilege);
    public Privilege getByName(@Param("name")String name);
}

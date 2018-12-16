package com.learnsystem.service;

import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;

import java.util.List;

public interface PrivilegeService {
    public int add(Privilege privilege);
    public int delete(int id);
    public int update(Privilege privilege);
    public List<Privilege> get(Privilege privilege);
}

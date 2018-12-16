package com.learnsystem.service;

import com.learnsystem.bean.Manager;

import java.util.List;

public interface ManagerService {
    public int add(Manager manager);
    public int delete(int id);
    public int update(Manager manager);
    public List<Manager> get(Manager manager);
}

package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.Impl.ManagerDaoImpl;
import com.example.socialnetwork.dao.ManagerDao;
import com.example.socialnetwork.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao=new ManagerDaoImpl();

    public boolean login(String managername, String password) {
        return managerDao.findManagerByNameAndPassword(managername,password);
    }
}

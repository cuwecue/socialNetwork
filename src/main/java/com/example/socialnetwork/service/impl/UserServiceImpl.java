package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.Impl.UserDaoImpl;
import com.example.socialnetwork.dao.UserDao;
import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;
import com.example.socialnetwork.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean regist(User user){
        return userDao.SaveUser(user);
    }

    @Override
    public boolean regist_1(Edu_work edu_work){ return userDao.SaveEdu_work(edu_work); }

    @Override
    public boolean updateinfo(Edu_work edu_work){ return userDao.SaveEdu_work_1(edu_work); }

    @Override
    public boolean updateinfo_1(User user) {
        return userDao.SaveUser_1(user);
    }

    @Override
    public boolean login(User user){
        return userDao.FindByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public Edu_work showinfo(String username){
        return userDao.FindByUsername(username);
    }

    @Override
    public User showinfo_1(String username){
        return userDao.FindByUsername_1(username);
    }

    @Override
    public List<User> showAllUsers() {
        System.out.println("3:service");
        return userDao.getAllUsers();
    }

    @Override
    public boolean DeleteUsers(String username) {
        return userDao.omitUser(username);
    }

    @Override
    public boolean edit(String username, String password, String name, String birthday,
                        String gender, String telephone, String email, String province,
                        String city) {
        return userDao.update(username,password,name,birthday, gender,telephone,email,
                province, city);
    }

}

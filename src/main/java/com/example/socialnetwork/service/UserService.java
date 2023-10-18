package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;

import java.util.List;

public interface UserService {
    boolean regist(User user);
    boolean regist_1(Edu_work edu_work);
    boolean updateinfo(Edu_work edu_work);
    boolean updateinfo_1(User user);
    boolean login(User user);
    Edu_work showinfo(String username);
    User showinfo_1(String username);
    public  abstract  List<User> showAllUsers();
    boolean DeleteUsers(String username);
    boolean edit(String username,String password,String name,String birthday,String gender,
    String telephone,String email,String province,String city);
}

package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;

import java.util.List;

public interface UserDao {
    boolean SaveUser(User user);
    boolean SaveUser_1(User user);
    boolean SaveEdu_work(Edu_work edu_work);
    boolean SaveEdu_work_1(Edu_work edu_work);
    boolean FindByUsernameAndPassword(String username, String password);
    Edu_work FindByUsername(String username);
    User FindByUsername_1(String username);
    public  abstract  List<User> getAllUsers();
    boolean omitUser(String username);
    boolean update(String username, String password, String name, String birthday,
                   String gender, String telephone, String email, String province,
                   String city);
}

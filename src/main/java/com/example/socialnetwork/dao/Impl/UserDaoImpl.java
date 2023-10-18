package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.UserDao;
import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean SaveUser(User user){
        String sql = "insert into user(username,password,name,birthday,gender,telephone,email,province,city) values (?,?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),
                    user.getName(),user.getBirthday(),user.getGender(),
                    user.getTelephone(),user.getEmail(),user.getProvince(),user.getCity());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean SaveUser_1(User user){
        String sql = "update user set name=?,birthday=?,gender=?,telephone=?,email=?,province=?,city=? where username=?";
        try {
            jdbcTemplate.update(sql,user.getName(),user.getBirthday(),user.getGender(),user.getTelephone(),
                    user.getEmail(),user.getProvince(),user.getCity(),user.getUsername());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean SaveEdu_work(Edu_work edu_work){
        String sql = "insert into edu_work(username,edu_level,edu_start,edu_end,school,degree,workplace,work_start,work_end,job) values(?,?,?,?,?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql,edu_work.getUsername(), edu_work.getEdu_level(), edu_work.getEdu_start(), edu_work.getEdu_end(), edu_work.getSchool(),
                    edu_work.getDegree(), edu_work.getWorkplace(), edu_work.getWork_start(), edu_work.getWork_end(), edu_work.getJob());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean SaveEdu_work_1(Edu_work edu_work){
        String sql = "update edu_work set edu_level=?,edu_start=?,edu_end=?,school=?,degree=?,workplace=?,work_start=?,work_end=?,job=? where username=?";
        try {
            jdbcTemplate.update(sql,edu_work.getEdu_level(),edu_work.getEdu_start(),edu_work.getEdu_end(),edu_work.getSchool(),
                    edu_work.getDegree(),edu_work.getWorkplace(),edu_work.getWork_start(),edu_work.getWork_end(),edu_work.getJob(),edu_work.getUsername());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean FindByUsernameAndPassword(String username, String password){
        User user = null;
        try {
            String sql = "select * from user where username = ? and password = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username,password);
        }catch (Exception e){

        }
        if (user!=null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Edu_work FindByUsername(String username) {
        Edu_work edu_work = null;
        try{
            String sql = "select * from edu_work where username = ?";
            edu_work = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Edu_work.class),username);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(edu_work!=null){
            return edu_work;
        }
        else {
            return null;
        }
    }

    @Override
    public User FindByUsername_1(String username){
        User user = null;
        try{
            String sql = "select * from user where username = ?";
            user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(user!=null){
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("4:dao");
        String sql = "select * from user";
        try {
            List<User> users = null;
            users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));

            return users;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean omitUser(String username) {
        String sql1="delete from user where username="+username+";";
        String sql2="delete from edu_work where username="+username+";";
        try{
            jdbcTemplate.update(sql1);
            jdbcTemplate.update(sql2);
            System.out.println("删除成功！");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String username, String password, String name, String birthday,
                          String gender, String telephone, String email, String province,
                          String city) {
        String sql = "update user set password=?, name=?, birthday=?, gender=?, " +
                "telephone=?, email=?, province=?, city=? where username=?";
        try{
            jdbcTemplate.update(sql,password,name,birthday,gender,telephone,
                    email,province,city,username);
            System.out.println("更新成功！");
            return  false;
        }catch (Exception e){
            e.printStackTrace();;
            return false;
        }
    }
}

package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.ManagerDao;
import com.example.socialnetwork.domain.Manager;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ManagerDaoImpl implements ManagerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public boolean findManagerByNameAndPassword(String managername, String password){
        Manager manager=new Manager();
        try {
            String sql = "select * from manager where managername = ? and password = ?";
            manager = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Manager.class),manager,password);
        }catch (Exception e){

        }
        if (manager!=null){
            return true;
        } else {
            return false;
        }
    }
}

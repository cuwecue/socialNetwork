package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.SearchDao;
import com.example.socialnetwork.domain.Search;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SearchDaoImpl implements SearchDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Search> getAllSearch() {

        String sql = "select * from blog_view";
        try {
            List<Search> searches = null;
            searches = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Search.class));

            return searches;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

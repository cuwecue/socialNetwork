package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.FriendsDao;
import com.example.socialnetwork.domain.Friends;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FriendsDaoImpl implements FriendsDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean SaveFriends(Friends friends) {
        String sql = "insert into friends(fid,user_1,user_2) values(?,?,?)";
        try {
            jdbcTemplate.update(sql,friends.getFid(),friends.getUser_1(),friends.getUser_2());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getFriends_num() {
        String sql = "select max(fid) from friends";
        try {
            Integer cnt = jdbcTemplate.queryForObject(sql,Integer.class);
            if (cnt == null)
                cnt = 0;
            return cnt;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<String> getAllFriends(String username) {
        String sql = "select user_1 from friends where user_2=? union all select user_2 from friends where user_1=?";
        try {
            List<String> friends = null;
            friends = jdbcTemplate.queryForList(sql,String.class,username,username);
            for (String friend : friends){
                System.out.println(friend);
            }
            System.out.println(username);
            return friends;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean omitFriend(String username, String friendname) {
        String sql="delete from friends where (user_1='"+username+"' and user_2='"+friendname+"') or" +
                " (user_1='"+friendname+"' and user_2='"+username+"' );";
        try{
            jdbcTemplate.update(sql);
            System.out.println("更新成功！");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

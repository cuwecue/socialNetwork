package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.Friends;

import java.util.List;

public interface FriendsDao {
    boolean SaveFriends(Friends friends);
    Integer getFriends_num();
    List<String> getAllFriends(String username);
    boolean omitFriend(String username,String friend);
}

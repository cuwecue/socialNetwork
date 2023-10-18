package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Friends;

import java.util.List;

public interface FriendsService {
    boolean AddFriends(Friends friends);
    Integer curFriends_num();
    List<String > showAllFriends(String username);
    boolean DeleteFriends(String username,String friendname);
}

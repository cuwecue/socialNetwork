package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.FriendsDao;
import com.example.socialnetwork.dao.Impl.FriendsDaoImpl;
import com.example.socialnetwork.dao.Impl.UserDaoImpl;
import com.example.socialnetwork.dao.UserDao;
import com.example.socialnetwork.domain.Friends;
import com.example.socialnetwork.service.FriendsService;

import java.util.List;

public class FriendsServiceImpl implements FriendsService {
    FriendsDao friendsDao = new FriendsDaoImpl();

    @Override
    public boolean AddFriends(Friends friends) {
        return friendsDao.SaveFriends(friends);
    }

    @Override
    public Integer curFriends_num() {
        return friendsDao.getFriends_num()+1;
    }

    @Override
    public List<String> showAllFriends(String username) {
        return friendsDao.getAllFriends(username);
    }

    @Override
    public boolean DeleteFriends(String username, String friendname) {
        return friendsDao.omitFriend(username,friendname);
    }
}

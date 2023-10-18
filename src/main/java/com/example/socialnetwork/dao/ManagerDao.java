package com.example.socialnetwork.dao;

public interface ManagerDao {
    boolean findManagerByNameAndPassword(String managername, String password);
}

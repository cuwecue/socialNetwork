package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class Blog implements Serializable {
    private int bid;
    private String title;
    private String main_body;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;
    private String username;
    private String part;
    private String picture;


    /**
     * 无参构造方法
     */
    public Blog() {
    }

    /**
     * 有参构方法
     *
     * @param bid
     * @param title
     * @param main_body
     * @param time
     * @param username
     *
     */
    public Blog(int bid,String title,String main_body,Timestamp time,String username,String part,String picture){
        this.bid = bid;
        this.title = title;
        this.main_body = main_body;
        this.time = time;
        this.username = username;
        this.part=part;
        this.picture=picture;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_body() {
        return main_body;
    }

    public void setMain_body(String main_body) {
        this.main_body = main_body;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}


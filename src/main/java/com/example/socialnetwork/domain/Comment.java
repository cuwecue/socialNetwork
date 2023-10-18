package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
    private Integer cid;
    private Integer bid;
    private String commenter;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;

    /**
     * 无参构造方法
     */
    public Comment() {
    }

    /**
     * 有参构方法
     *
     * @param cid
     * @param bid
     * @param commenter
     * @param content
     * @param time
     *
     */
    public Comment(Integer cid,Integer bid,String commenter,String content,Timestamp time){
        this.cid = cid;
        this.bid = bid;
        this.commenter = commenter;
        this.content = content;
        this.time = time;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}

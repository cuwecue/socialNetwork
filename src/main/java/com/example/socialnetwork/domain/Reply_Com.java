package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Reply_Com {
    private Integer rid;
    private Integer bid;
    private String replier;
    private String commenter;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp com_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp rep_time;

    /**
     * 无参构造方法
     */
    public Reply_Com() {
    }


    /**
     * 有参构方法
     *
     * @param rid
     * @param bid
     * @param replier
     * @param commenter
     * @param content
     * @param com_time
     * @param rep_time
     *
     */
    public Reply_Com(Integer rid,Integer bid,String  replier,String commenter,String content,Timestamp com_time,Timestamp rep_time){
        this.rid = rid;
        this.bid = bid;
        this.replier = replier;
        this.commenter = commenter;
        this.content = content;
        this.com_time = com_time;
        this.rep_time = rep_time;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
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

    public Timestamp getCom_time() {
        return com_time;
    }

    public void setCom_time(Timestamp com_time) {
        this.com_time = com_time;
    }

    public Timestamp getRep_time() {
        return rep_time;
    }

    public void setRep_time(Timestamp rep_time) {
        this.rep_time = rep_time;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
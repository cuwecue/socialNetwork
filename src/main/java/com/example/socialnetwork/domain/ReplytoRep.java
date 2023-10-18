package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplytoRep implements Serializable {
    private int rid;
    private int target_rid;
    private String replier;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;

    /**
     * 无参构造方法
     */
    public ReplytoRep() {
    }

    /**
     * 有参构方法
     *
     * @param rid
     * @param target_rid
     * @param replier
     * @param content
     * @param time
     *
     */
    public ReplytoRep(int rid,int target_rid,String replier,String content,Timestamp time){
        this.rid = rid;
        this.target_rid = target_rid;
        this.replier = replier;
        this.content = content;
        this.time = time;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getTarget_rid() {
        return target_rid;
    }

    public void setTarget_rid(int target_rid) {
        this.target_rid = target_rid;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
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

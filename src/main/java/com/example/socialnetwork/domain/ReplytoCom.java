package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplytoCom implements Serializable {
    private int rid;
    private int cid;
    private String replier;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;

    /**
     * 无参构造方法
     */
    public ReplytoCom() {
    }

    /**
     * 有参构方法
     *
     * @param rid
     * @param cid
     * @param replier
     * @param content
     * @param time
     *
     */
    public ReplytoCom(int rid,int cid,String replier,String content,Timestamp time){
        this.rid = rid;
        this.cid = cid;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

package com.example.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Reply_Rep {
    private String replier;
    private String tar_replier;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp tar_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp rep_time;

    /**
     * 无参构造方法
     */
    public Reply_Rep() {
    }


    /**
     * 有参构方法
     *
     * @param replier
     * @param tar_replier
     * @param content
     * @param tar_time
     * @param rep_time
     *
     */
    public Reply_Rep(String  replier,String tar_replier,String content,Timestamp tar_time,Timestamp rep_time){
        this.replier = replier;
        this.tar_replier = tar_replier;
        this.content = content;
        this.tar_time = tar_time;
        this.rep_time = rep_time;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
    }

    public String getTar_replier() {
        return tar_replier;
    }

    public void setTar_replier(String tar_replier) {
        this.tar_replier = tar_replier;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTar_time() {
        return tar_time;
    }

    public void setTar_time(Timestamp tar_time) {
        this.tar_time = tar_time;
    }

    public Timestamp getRep_time() {
        return rep_time;
    }

    public void setRep_time(Timestamp rep_time) {
        this.rep_time = rep_time;
    }
}

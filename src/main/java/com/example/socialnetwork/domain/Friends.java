package com.example.socialnetwork.domain;

public class Friends {
    private int fid;
    private String user_1;
    private String user_2;

    /**
     * 无参构造方法
     */
    public Friends() {
    }


    /**
     * 有参构方法
     *
     * @param fid
     * @param user_1
     * @param user_2
     *
     */
    public Friends(int fid,String user_1,String user_2){
        this.fid = fid;
        this.user_1 = user_1;
        this.user_2 = user_2;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUser_1() {
        return user_1;
    }

    public void setUser_1(String user_1) {
        this.user_1 = user_1;
    }

    public String getUser_2() {
        return user_2;
    }

    public void setUser_2(String user_2) {
        this.user_2 = user_2;
    }
}

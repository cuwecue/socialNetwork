package com.example.socialnetwork.domain;

public class Search {

    private String v_username;
    private String v_province;
    private String v_gender;
    private String v_degree;
    private String v_title;
    private String v_main_body;
    private int v_bid;

    public Search(){

    }

    public Search(String v_username, String v_province, String v_gender, String v_degree, String v_title, String v_main_body, int v_bid) {
        this.v_username = v_username;
        this.v_province = v_province;
        this.v_gender = v_gender;
        this.v_degree = v_degree;
        this.v_title = v_title;
        this.v_main_body = v_main_body;
        this.v_bid = v_bid;
    }

    public String getV_username() {
        return v_username;
    }

    public void setV_username(String v_username) {
        this.v_username = v_username;
    }

    public String getV_province() {
        return v_province;
    }

    public void setV_province(String v_province) {
        this.v_province = v_province;
    }

    public String getV_gender() {
        return v_gender;
    }

    public void setV_gender(String v_gender) {
        this.v_gender = v_gender;
    }

    public String getV_degree() {
        return v_degree;
    }

    public void setV_degree(String v_degree) {
        this.v_degree = v_degree;
    }

    public String getV_title() {
        return v_title;
    }

    public void setV_title(String v_title) {
        this.v_title = v_title;
    }

    public String getV_main_body() {
        return v_main_body;
    }

    public void setV_main_body(String v_main_body) {
        this.v_main_body = v_main_body;
    }

    public int getV_bid() {
        return v_bid;
    }

    public void setV_bid(int v_bid) {
        this.v_bid = v_bid;
    }
}

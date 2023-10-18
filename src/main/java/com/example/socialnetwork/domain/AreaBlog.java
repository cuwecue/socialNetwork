package com.example.socialnetwork.domain;

public class AreaBlog {
    private Integer num;
    private String province;
    private String city;

    /**
     * 无参构造方法
     */
    public AreaBlog(){

    }

    /**
     * 有参构造方法
     *
     * @param num
     * @param province
     * @param city
     *
     */
    public AreaBlog(Integer num,String province,String city){
        this.num = num;
        this.province = province;
        this.city = city;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

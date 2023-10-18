package com.example.socialnetwork.domain;

import java.io.Serializable;

public class Edu_work implements Serializable {
    private String username;
    private String edu_level;
    private String edu_start;
    private String edu_end;
    private String school;
    private String degree;
    private String workplace;
    private String work_start;
    private String work_end;
    private String job;

    /**
     * 无参构造方法
     */
    public Edu_work() {
    }

    /**
     * 有参构方法
     *
     * @param username
     * @param edu_level
     * @param edu_start
     * @param edu_end
     * @param school
     * @param degree
     * @param workplace
     * @param work_start
     * @param work_end
     * @param job
     *
     */

    public Edu_work(String username, String edu_level, String edu_start, String edu_end, String school, String degree, String workplace, String work_start, String work_end, String job){
        this.username = username;
        this.edu_level = edu_level;
        this.edu_start = edu_start;
        this.edu_end = edu_end;
        this.school = school;
        this.degree = degree;
        this.workplace = workplace;
        this.work_start = work_start;
        this.work_end = work_end;
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEdu_level() {
        return edu_level;
    }

    public void setEdu_level(String edu_level) {
        this.edu_level = edu_level;
    }

    public String getEdu_start() {
        return edu_start;
    }

    public void setEdu_start(String edu_start) {
        this.edu_start = edu_start;
    }

    public String getEdu_end() {
        return edu_end;
    }

    public void setEdu_end(String edu_end) {
        this.edu_end = edu_end;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getWork_start() {
        return work_start;
    }

    public void setWork_start(String work_start) {
        this.work_start = work_start;
    }

    public String getWork_end() {
        return work_end;
    }

    public void setWork_end(String work_end) {
        this.work_end = work_end;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

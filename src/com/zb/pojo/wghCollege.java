package com.zb.pojo;

public class wghCollege {
    private Integer wgh_id;
    private String wgh_name;
    private String wgh_leader;
    private Integer wgh_teacherNum;
    private Integer wgh_studentNum;
    private String wgh_promotionRate;

    @Override
    public String toString() {
        return "College{" +
                "wgh_id=" + wgh_id +
                ", wgh_name='" + wgh_name + '\'' +
                ", wgh_leader='" + wgh_leader + '\'' +
                ", wgh_teacherNum=" + wgh_teacherNum +
                ", wgh_studentNum=" + wgh_studentNum +
                ", wgh_promotionRate='" + wgh_promotionRate + '\'' +
                '}';
    }

    public Integer getWgh_id() {
        return wgh_id;
    }

    public void setWgh_id(Integer wgh_id) {
        this.wgh_id = wgh_id;
    }

    public String getWgh_name() {
        return wgh_name;
    }

    public void setWgh_name(String wgh_name) {
        this.wgh_name = wgh_name;
    }

    public String getWgh_leader() {
        return wgh_leader;
    }

    public void setWgh_leader(String wgh_leader) {
        this.wgh_leader = wgh_leader;
    }

    public Integer getWgh_teacherNum() {
        return wgh_teacherNum;
    }

    public void setWgh_teacherNum(Integer wgh_teacherNum) {
        this.wgh_teacherNum = wgh_teacherNum;
    }

    public Integer getWgh_studentNum() {
        return wgh_studentNum;
    }

    public void setWgh_studentNum(Integer wgh_studentNum) {
        this.wgh_studentNum = wgh_studentNum;
    }

    public String getWgh_promotionRate() {
        return wgh_promotionRate;
    }

    public void setWgh_promotionRate(String wgh_promotionRate) {
        this.wgh_promotionRate = wgh_promotionRate;
    }
}

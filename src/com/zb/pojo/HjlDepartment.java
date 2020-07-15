package com.zb.pojo;

/**
 * @author: l
 * @date: 2020-7-13 22:18
 * @description:
 */
public class HjlDepartment {
    private int depart_id;
    private  String depart_name;

    @Override
    public String toString() {
        return "HjlDepartment{" +
                "depart_id=" + depart_id +
                ", depart_name='" + depart_name + '\'' +
                ", room_num=" + room_num +
                ", depart_dir='" + depart_dir + '\'' +
                '}';
    }

    private  int room_num;
    private  String depart_dir;

    public int getDepart_id() {
        return depart_id;
    }

    public HjlDepartment setDepart_id(int depart_id) {
        this.depart_id = depart_id;
        return this;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public HjlDepartment setDepart_name(String depart_name) {
        this.depart_name = depart_name;
        return this;
    }

    public int getRoom_num() {
        return room_num;
    }

    public HjlDepartment setRoom_num(int room_num) {
        this.room_num = room_num;
        return this;
    }

    public String getDepart_dir() {
        return depart_dir;
    }

    public HjlDepartment setDepart_dir(String depart_dir) {
        this.depart_dir = depart_dir;
        return this;
    }
}

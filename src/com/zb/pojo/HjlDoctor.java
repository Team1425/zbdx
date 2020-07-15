package com.zb.pojo;

/**
 * @author: l
 * @date: 2020-7-13 22:06
 * @description:
 */
public class HjlDoctor {
    private  int doctor_id;
    private  int depart_id;
    private String doctor_name;
    private  String doctor_tel;
    private String doctor_addr;
    private String doctor_sex;

    @Override
    public String toString() {
        return "HjlDoctor{" +
                "doctor_id=" + doctor_id +
                ", depart_id=" + depart_id +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_tel='" + doctor_tel + '\'' +
                ", doctor_addr='" + doctor_addr + '\'' +
                ", doctor_sex='" + doctor_sex + '\'' +
                '}';
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public HjlDoctor setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
        return this;
    }

    public int getDepart_id() {
        return depart_id;
    }

    public HjlDoctor setDepart_id(int depart_id) {
        this.depart_id = depart_id;
        return this;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public HjlDoctor setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
        return this;
    }

    public String getDoctor_tel() {
        return doctor_tel;
    }

    public HjlDoctor setDoctor_tel(String doctor_tel) {
        this.doctor_tel = doctor_tel;
        return this;
    }

    public String getDoctor_addr() {
        return doctor_addr;
    }

    public HjlDoctor setDoctor_addr(String doctor_addr) {
        this.doctor_addr = doctor_addr;
        return this;
    }

    public String getDoctor_sex() {
        return doctor_sex;
    }

    public HjlDoctor setDoctor_sex(String doctor_sex) {
        this.doctor_sex = doctor_sex;
        return this;
    }
}

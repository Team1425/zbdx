package com.zb.pojo;

public class Szb_Exa {
    private String exa_id;
    private String exa_name;
    private String exa_room;
    private String exa_time;
    private String exa_teacher;
    private String exa_teacherId;

    public String getExa_id() {
        return exa_id;
    }

    public void setExa_id(String id) {
        this.exa_id = id;
    }

    public String getExa_name() {
        return exa_name;
    }

    public void setExa_name(String exa_name) {
        this.exa_name = exa_name;
    }

    public String getExa_room() {
        return exa_room;
    }

    public void setExa_room(String exa_room) {
        this.exa_room = exa_room;
    }

    public String getExa_time() {
        return exa_time;
    }

    public void setExa_time(String exa_time) {
        this.exa_time = exa_time;
    }

    public String getExa_teacher() {
        return exa_teacher;
    }

    public void setExa_teacher(String exa_teacher) {
        this.exa_teacher = exa_teacher;
    }

    public String getExa_teacherId() {
        return exa_teacherId;
    }

    public void setExa_teacherId(String exa_teacherId) {
        this.exa_teacherId = exa_teacherId;
    }

    @Override
    public String toString() {
        return "Szb_Exa{" +
                "exa_id='" + exa_id + '\'' +
                ", exa_name='" + exa_name + '\'' +
                ", exa_room='" + exa_room + '\'' +
                ", exa_time='" + exa_time + '\'' +
                ", exa_teacher='" + exa_teacher + '\'' +
                ", exa_teacherId='" + exa_teacherId + '\'' +
                '}';
    }
}

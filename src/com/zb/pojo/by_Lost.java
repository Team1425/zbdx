package com.zb.pojo;

import java.sql.Timestamp;

public class by_Lost {

    private Integer id;
    private String type;
    private String trait;
    private Timestamp time;
    private String lost_loc;
    private String get_loc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLost_loc() {
        return lost_loc;
    }

    public void setLost_loc(String lost_loc) {
        this.lost_loc = lost_loc;
    }

    public String getGet_loc() {
        return get_loc;
    }

    public void setGet_loc(String get_loc) {
        this.get_loc = get_loc;
    }

    @Override
    public String toString() {
        return "by_Lost{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", trait='" + trait + '\'' +
                ", time=" + time +
                ", lost_loc='" + lost_loc + '\'' +
                ", get_loc='" + get_loc + '\'' +
                '}';
    }
}

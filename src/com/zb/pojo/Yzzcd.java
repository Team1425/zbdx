package com.zb.pojo;

public class Yzzcd {
    private Integer id;
    private Integer ct_id;
    private  String CD_name;
    private String CD_price;
    private  String CD_type;
    private String CT_name;

    public String getCT_name() {
        return CT_name;
    }

    public void setCT_name(String CT_name) {
        this.CT_name = CT_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCt_id() {
        return ct_id;
    }

    public void setCt_id(Integer ct_id) {
        this.ct_id = ct_id;
    }

    public String getCD_name() {
        return CD_name;
    }

    public void setCD_name(String CD_name) {
        this.CD_name = CD_name;
    }

    public String getCD_price() {
        return CD_price;
    }

    public void setCD_price(String CD_price) {
        this.CD_price = CD_price;
    }

    public String getCD_type() {
        return CD_type;
    }

    public void setCD_type(String CD_type) {
        this.CD_type = CD_type;
    }
}

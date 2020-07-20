package com.zb.pojo;

public class Szb_ExaRoot {

    private String exaAdRoot;
    private String pwd;
    private String exaId;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getExaAdRoot() {
        return exaAdRoot;
    }

    public void setExaAdRoot(String exaAdRoot) {
        this.exaAdRoot = exaAdRoot;
    }

    public String getId() {
        return exaId;
    }

    public void setId(String exaId) {
        this.exaId = exaId;
    }

    @Override
    public String toString() {
        return "Szb_ExaRoot{" +
                "exaAdRoot='" + exaAdRoot + '\'' +
                ", pwd='" + pwd + '\'' +
                ", exaId='" + exaId + '\'' +
                '}';
    }
}

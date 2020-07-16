package com.zb.pojo;

public class HlzStudent {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String number;

    public HlzStudent(String name, String sex, Integer age, String number) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.number = number;
    }

    public HlzStudent(Integer id, String name, String sex, Integer age, String number) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.number = number;
    }

    public HlzStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

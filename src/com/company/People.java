package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class People {
    private String name;
    private int age;
    private Date brith;

    public String getBrithStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String BrithStr = sdf.format(brith);
        return BrithStr;
    }

    public People() {
    }

    public People(String name, int age, Date brith) {
        this.name = name;
        this.age = age;
        this.brith = brith;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }
}

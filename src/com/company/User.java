package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private Date  date;

    //解析成的属性就是dateStr
    //去掉get，首字母小写
    public String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        return format;
    }

    public User() {
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

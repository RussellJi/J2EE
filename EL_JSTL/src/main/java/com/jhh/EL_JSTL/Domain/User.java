package com.jhh.EL_JSTL.Domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private Date date;

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
    public String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        return sdf.format(this.date);
    }

}

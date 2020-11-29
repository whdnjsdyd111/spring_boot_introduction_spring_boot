package com.example.spring_boot_introduction_spring_boot.chpater07;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class MyDataMongo {
    @Id
    private String id;

    private String name;
    private String memo;
    private Date date;

    public MyDataMongo(String name, String memo) {
        super();
        this.name = name;
        this.memo = memo;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMemo() {
        return memo;
    }

    public Date getDate() {
        return date;
    }
}

package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDataBean {

    @Autowired
    MyDataRepository repository;

    public String getTableTagById(Long id) {
        MyData data = repository.getOne(id);    // 원래 repository.findOne(id) 인데 해당 메소드는 Optional 을 리턴한다.
        String result = "<tr><td>" + data.getName()
                + "</td><td>" + data.getMail()
                + "</td><td>" + data.getAge()
                + "</td><td>" + data.getMemo()
                + "</td></tr>";
        return result;
    }
}

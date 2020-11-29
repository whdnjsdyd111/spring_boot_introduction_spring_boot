package com.example.spring_boot_introduction_spring_boot.chpater07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyDataRestController {

    @Autowired
    private MyDataService service;

    @RequestMapping("/rest")
    public List<MyData> restAll() {
        return service.getAll();
    }

    @RequestMapping("/rest/{num}")
    public MyData restBy(@PathVariable int num) {
        return service.get(num);
    }
}

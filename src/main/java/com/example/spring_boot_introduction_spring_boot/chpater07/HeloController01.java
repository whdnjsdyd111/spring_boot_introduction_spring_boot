package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HeloController01 {

    @Autowired
    MyDataRepository repository;

    @Autowired
    private MyDataService service;

    @RequestMapping(value = "/index01", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index01");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        List<MyData> list = service.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @PostConstruct
    public void init() {
        MyData d1 = new MyData();
        d1.setName("kim");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
        d1.setMemo("090999999");
        repository.save(d1);

        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("080888888");
        repository.save(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("070777777");
        repository.save(d3);
    }
}

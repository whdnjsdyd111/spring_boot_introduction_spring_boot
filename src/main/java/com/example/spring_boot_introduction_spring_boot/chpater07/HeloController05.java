package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class HeloController05 {

    @Autowired
    MyDataRepository repository;

    @Autowired
    private MyDataService04 service;

    @RequestMapping(value = "/page/{num}", method = RequestMethod.GET)
    public ModelAndView page(@PathVariable Integer num, ModelAndView mav) {
        Page<MyData> page = service.getMyDataInPage(num);
        mav.setViewName("index02");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        mav.addObject("pagenumber", num);
        mav.addObject("datalist", page);
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

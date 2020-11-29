package com.example.spring_boot_introduction_spring_boot.chpater07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MyBootAppConfig06 {

    @Autowired
    MyDataBean myDataBean;

    @Autowired
    private MyDataService04 service;

    @Bean
    MyTLDialect myTLDialect() {
        return new MyTLDialect();
    }

    @RequestMapping(value = "/dialect/{num}", method = RequestMethod.GET)
    public ModelAndView indexById(@PathVariable Integer num, ModelAndView mav) {
        Page<MyData> page = service.getMyDataInPage(num);
        mav.setViewName("index06");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        mav.addObject("pagenumber", num);
        mav.addObject("datalist", page);
        return mav;
    }
}

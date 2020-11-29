package com.example.spring_boot_introduction_spring_boot.chpater07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MyBootAppConfig03 {

    @Autowired
    MyDataBean myDataBean;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView indexById(@PathVariable long id, ModelAndView mav) {
        mav.setViewName("pickup");
        mav.addObject("title", "Pickup Page");
        String table = "<table>"
                + myDataBean.getTableTagById(id)
                + "</table>";
        mav.addObject("msg", "pickup data id = " + id);
        mav.addObject("data", "table");
        return mav;
    }
}

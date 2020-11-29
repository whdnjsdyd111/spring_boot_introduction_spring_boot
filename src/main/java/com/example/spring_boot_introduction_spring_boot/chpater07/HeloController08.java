package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataMongoRepository;
import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataMongoRepository08;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HeloController08 {

    @Autowired
    MyDataMongoRepository08 repository;

    @RequestMapping(value = "/index08", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index08");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/index08", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(
            @RequestParam("name") String name,
            @RequestParam("memo") String memo,
            ModelAndView mav) {
        MyDataMongo mydata = new MyDataMongo(name, memo);
        repository.save(mydata);
        return new ModelAndView("redirect:/index08");
    }

    @RequestMapping(value = "/find08", method = RequestMethod.GET)
    public ModelAndView find(ModelAndView mav) {
        mav.setViewName("/find08");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        mav.addObject("value", "");
        List<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/find08", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("find") String param, ModelAndView mav) {
        mav.setViewName("find08");
        if(param == "")
            mav = new ModelAndView("redirect:/find08");
        else {
            mav.addObject("title", "Find result");
            mav.addObject("msg", "「" + param + "」 의 검색 결과");
            mav.addObject("value", param);
            List<MyDataMongo> list = repository.findByName(param);
            mav.addObject("datalist", list);
        }
        return mav;
    }
}

package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataMongoRepository;
import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class HeloController07 {

    @Autowired
    MyDataMongoRepository repository;

    @RequestMapping(value = "/index07", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index07");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData 의 예제입니다.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/index07", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(
            @RequestParam("name") String name,
            @RequestParam("memo") String memo,
            ModelAndView mav) {
        MyDataMongo mydata = new MyDataMongo(name, memo);
        repository.save(mydata);
        return new ModelAndView("redirect:/index07");
    }
}

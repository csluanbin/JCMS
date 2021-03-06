package com.maven.luanbin.archetype.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luanbin on 10/21/16.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "q3boy");
        map.put("password", "q3girl");
        LOGGER.info("this is info");
        LOGGER.warn("this is warn");
        LOGGER.error("this is error");

        return map.toString();
    }

    @RequestMapping(value = "/testVm", method = RequestMethod.GET)
    public ModelAndView testVm() {
        ModelAndView mav= new ModelAndView();
        mav.addObject("city", "test");
        mav.setViewName("hello");
        return mav;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession httpSession) {
        httpSession.setAttribute("login", true);
        ModelAndView mav= new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}

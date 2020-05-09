package org.galaxy.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.galaxy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {
    public static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/method1", method = RequestMethod.POST)
    @ResponseBody
    public String method1(HttpServletRequest request, @RequestBody User user) {
        logger.info("call method1 ");
        return "success method1";
    }

    @RequestMapping(value = "/method2", method = RequestMethod.GET)
    @ResponseBody
    public String method2(HttpServletRequest request, @RequestBody User user){
        logger.info("call method2 ");
        return "success method2";
    }

}

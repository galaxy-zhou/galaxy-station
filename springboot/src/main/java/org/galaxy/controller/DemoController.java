package org.galaxy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.galaxy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/method1.do", method = RequestMethod.POST)
    @ResponseBody
    public String method1(HttpServletRequest request, @RequestBody User user) {
        logger.info("call method1 ");
        return "success method1";
    }

    @RequestMapping(value = "/method2.do", method = RequestMethod.GET)
    @ResponseBody
    public String method2(HttpServletRequest request, @RequestBody User user) throws JsonProcessingException {
        logger.info("call method2 ");
        return "success method2";
    }

    @RequestMapping(value = "/method3.do", method = RequestMethod.GET)
    @ResponseBody
    public String method3(HttpServletRequest request) throws JsonProcessingException {
        logger.info("call method3 ");
        String userStr2 = "{\"username\":\"zht\",\"password\":\"p@ssw0rd\"}";

        User user2 = objectMapper.readValue(userStr2,User.class);
        System.out.println(user2.getUsername()+"||||"+user2.getPassword());
        return "success method3";
    }

}

package com.prystupa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceController.class);

    @RequestMapping("/five")
    @ResponseBody
    public String getFive() {
        LOGGER.info("getFive called");
        return "five";
    }

    @RequestMapping(value = "/point")
    @ResponseBody
    public Point getPoint() {
        LOGGER.info("getPoint called");
        return new Point(5, 10);
    }
}

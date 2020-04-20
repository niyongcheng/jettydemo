package com.niyongcheng.jettydemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class RedisController {
    //
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ReturnDefaultPage() {
        return "Hello Spring Boot";
    }
}

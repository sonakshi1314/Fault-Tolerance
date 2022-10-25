package com.faultTolerance.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ServiceB {

    @GetMapping("/b")
    public String serviceB(){
        return "Service B is called from Service A";
    }
}

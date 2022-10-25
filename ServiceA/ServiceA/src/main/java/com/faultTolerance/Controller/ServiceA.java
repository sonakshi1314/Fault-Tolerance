package com.faultTolerance.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceA")
public class ServiceA {
    public static final String SERVICE_A = "serviceA";
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL="http://localhost:8082";


    @GetMapping("/a")
    @CircuitBreaker(name =
            SERVICE_A ,fallbackMethod = "serviceAFallback")
    public String serviceA(){
        String url ="/serviceB/b" ;
        return restTemplate.getForObject(BASE_URL + url, String.class);
    }

    public String serviceAFallback(Exception e){
        return "Fallback method for Service A called.";

    }

}

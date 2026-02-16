package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // Makes this class a REST API controller
public class HelloController {

    @GetMapping("/hello")   // URL: http://localhost:8080/hello
    public String sayHello() {
        return "Hello World!";
    }
}

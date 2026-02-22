package com.example.demo;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // Makes this class a REST API controller
@CrossOrigin // allow frontend calls
@RequestMapping("/api/test")
public class HelloController {

    @GetMapping("/hello")   // URL: http://localhost:8080/api/test/hello
    public String sayHello() {
        return "Hello World!";
    }
     @PostMapping("/greet")
    public String greet(@RequestBody String name) {
        return "Hello " + name + "!";
    }
}

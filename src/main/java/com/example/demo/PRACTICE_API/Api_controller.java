package com.example.demo.PRACTICE_API;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // allow frontend calls
@RequestMapping("/api")
public class Api_controller {


    @GetMapping("/hello") //http://localhost:8080/api/hello  mvn clean spring-boot:run   mvn spring-boot:run
    public String hello() {
        return "Hello from Spring Boot!";
    }

@PostMapping("/greet")
public String greet(@RequestBody GreetRequesst request) {

    return "Hello "
            + request.getName() + " "
            + request.getPhone() + " "
            + request.getZip();
           
             
}


}
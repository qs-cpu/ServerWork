package com.xzy212306259.hello_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot应用正在运行！";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot! 欢迎使用RESTful API服务！";
    }
}
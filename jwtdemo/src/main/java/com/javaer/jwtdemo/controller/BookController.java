package com.javaer.jwtdemo.controller;


import com.javaer.jwtdemo.service.Token;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/")
    public String index(){
        return "i am real index page";
    }

    @GetMapping("/index")
    public String index2(){
        return "i am index page";
    }

    @GetMapping("/login")
    public String user(){
        return "<form method=post action='/login'><input type='text' name='name'><input type='text' name='pwd'><input type='submit' value=submit></form>";
    }

    @PostMapping("/login")
    public String userLoginIn(@RequestParam(name = "name") String name,@RequestParam(name = "pwd") String pwd)
    {
        String token = Token.token(name,pwd);
        return "post me:" + name + " | "+  pwd + " | token is " + token;
    }
}

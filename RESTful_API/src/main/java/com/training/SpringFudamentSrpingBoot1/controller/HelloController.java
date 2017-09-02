package com.training.SpringFudamentSrpingBoot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/Hello", method = {RequestMethod.GET})
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setMessage("Hello. My Name is Pete ");
        return hello;
    }
class Hello {
    String message = "";

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
    }



}

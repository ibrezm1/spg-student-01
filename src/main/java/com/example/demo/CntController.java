package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CntController {
    @Autowired
    private MyBean myBean;

    @GetMapping("/test")
    public String test() {
        return myBean.getTestProperty();
    }

}

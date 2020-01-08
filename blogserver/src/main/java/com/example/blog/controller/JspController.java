package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JspController {

    @GetMapping("/jsp")
    public String jsp(Model model){
        System.out.println("try jsp");
        model.addAttribute("msg","测试jsp页面！！！");
        return "myJsp";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg","测试thymeleaf页面！！！");
        return "html/myThymeleaf";
    }

}
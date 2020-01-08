package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class JspController {

    @GetMapping("/jsp")
    public String jsp(Model model){
        System.out.println("try jsp");
        model.addAttribute("msg","测试jsp页面！！！");
        return "myJsp";
    }

    @GetMapping("about_us")
    public String about(Model model) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        model.addAttribute("time1", dateNowStr);
        return "about";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg","测试thymeleaf页面！！！");
        return "html/myThymeleaf";
    }
}
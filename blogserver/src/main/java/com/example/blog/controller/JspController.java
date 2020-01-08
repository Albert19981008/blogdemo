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
        String msg1 = "欢迎使用李昕旸和刘洋凡做的博客项目";
        String msg2 = "本项目后端主要技术栈为 spring boot mybatis";
        String msg3 = "本项目前端主要技术栈为 vue + 少量jsp";
        String msg4 = "如果有问题请联系 741162208@qq.com";
        model.addAttribute("msg1", msg1);
        model.addAttribute("msg2", msg2);
        model.addAttribute("msg3", msg3);
        model.addAttribute("msg4", msg4);
        return "about";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg","测试thymeleaf页面！！！");
        return "html/myThymeleaf";
    }
}
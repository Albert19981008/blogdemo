package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Vue 的页面默认是静态的HTML和JS
 * 加上这个配置使得访问本网站 直接跳到index.html
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
//        return "forward:index.html";  这个是网址栏不换为新URL的版本
        return "redirect:index.html";
    }
}

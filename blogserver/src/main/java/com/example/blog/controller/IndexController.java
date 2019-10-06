package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Vue 的页面都是访问 index.html 然后用 js 动态加载的
 * 加上这个配置使得访问本网站 使得 "/" 直接跳到index.html
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
//        return "forward:index.html";  这个是网址栏不换为新URL的版本
        return "redirect:index.html";
    }
}

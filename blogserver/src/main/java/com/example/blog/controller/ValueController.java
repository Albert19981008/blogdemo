package com.example.blog.controller;

import com.example.blog.bean.Value;
import com.example.blog.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValueController {

    @Autowired
    private ValueService valueService;

    @GetMapping("/values")
    public List<Value> getAllValues() {
        return valueService.getAllValues();
    }

    @PostMapping("/value/add")
    public void addValue(Value value) {
        valueService.addValue(value);
    }

    @DeleteMapping("/value/delete")
    public void deleteValue(int id) {
        valueService.deleteValue(id);
    }
}

package com.example.blog.service;

import com.example.blog.bean.Value;

import java.util.List;

public interface ValueService {

    List<Value> getAllValues();

    int getMaxId();

    void addValue(Value value);

    void deleteValue(int id);
}

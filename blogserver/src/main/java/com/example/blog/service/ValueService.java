package com.example.blog.service;

import com.example.blog.bean.Value;

import java.util.List;

public interface ValueService {

    List<Value> getAllValues();

    Value getValueById(Integer id);

    int getMaxId();

    boolean addValue(Value value);

    boolean updateValue(Value value);

    boolean deleteValue(Integer id);
}

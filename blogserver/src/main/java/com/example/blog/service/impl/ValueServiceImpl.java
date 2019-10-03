package com.example.blog.service.impl;

import com.example.blog.bean.Value;
import com.example.blog.dao.ValueDao;
import com.example.blog.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {

    @Autowired
    private ValueDao valueDao;

    @Override
    public List<Value> getAllValues() {
        return valueDao.getAllValues();
    }

    @Override
    public int getMaxId() {
        return valueDao.getMaxId();
    }

    @Override
    public void addValue(Value value) {
        int maxId = valueDao.getMaxId();
        value.setId(maxId + 1);
        valueDao.addValue(value);
    }

    @Override
    public void deleteValue(int id) {
        valueDao.deleteValue(id);
    }
}

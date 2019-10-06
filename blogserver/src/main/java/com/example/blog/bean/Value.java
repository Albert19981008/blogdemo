package com.example.blog.bean;

import java.io.Serializable;

/**
 * 价值观 
 * 实体类
 */
public class Value implements Serializable {
    private Integer id;
    private String name;
    private String explanation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}

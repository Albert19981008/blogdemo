package com.example.blog.dao;

import com.example.blog.bean.Value;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ValueDao {

    @Select("select * from value_table")
    List<Value> getAllValues();

    @Select("select max(id) from value_table")
    int getMaxId();

    @Insert("insert into value_table values (#{id}, #{name}, #{explanation})")
    void addValue(Value value);

    @Delete("delete from value_table where id = #{id}")
    void deleteValue(int id);
}

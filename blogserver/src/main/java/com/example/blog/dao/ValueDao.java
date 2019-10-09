package com.example.blog.dao;

import com.example.blog.bean.Value;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 处理价值观那张表的 dao
 */
@Mapper
public interface ValueDao {

    @Select("select * from value_table")
    List<Value> getAllValues();

    @Select("select * from value_table where id = #{id}")
    Value getValueById(Integer id);

    @Select("select max(id) from value_table")
    int getMaxId();

    @Insert("insert into value_table values (#{id}, #{name}, #{explanation})")
    void addValue(Value value);

    @Delete("delete from value_table where id = #{id}")
    void deleteValue(Integer id);

    @Update("update value_table set name = #{name}, explanation = #{explanation} where id = #{id}")
    void updateValue(Value value);
}

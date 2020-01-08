package com.example.blog.dao;

import com.example.blog.bean.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TopicDao {

    @Select("select * from topic")
    List<Topic> getAllTopics();

    @Select("select * from topic where id = #{id}")
    Topic getTopicById(Integer id);

    @Select("select * from topic where name = #{name}")
    Topic getTopicByName(String name);

    @Select("select max(id) from topic")
    int getMaxId();

    @Insert("insert into topic values (#{id}, #{name})")
    void addTopic(Topic topic);

    @Delete("delete from topic where id = #{id}")
    void deleteTopic(Integer id);

    @Update("update topic set name = #{name} where id = #{id}")
    void updateTopic(Topic topic);
}

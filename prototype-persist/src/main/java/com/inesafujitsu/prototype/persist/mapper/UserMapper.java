package com.inesafujitsu.prototype.persist.mapper;

import com.inesafujitsu.prototype.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //    @Select("SELECT * FROM user")
    List<User> getAll();

    //    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Long id);

    //    @Insert("INSERT INTO user(id, name, age, email, gender) VALUES(#{id}, #{name}, #{age}, #{email), ${gender")
    void insert(User user);

    //    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id =#{id}")
    void update(User user);

    //    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    String checkDatabase();

}

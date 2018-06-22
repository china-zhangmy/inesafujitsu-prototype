package com.inesafujitsu.prototype.platform.persist.mapper;

import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends AbstractMapper<User> {

    //    @Select("SELECT * FROM user")
//    List<User> getAll();

    //    @Select("SELECT * FROM user WHERE id = #{id}")
//    User getOne(String id);

    //    @Insert("INSERT INTO user(id, name, age, email, gender) VALUES(#{id}, #{name}, #{age}, #{email), ${gender")
//    void insert(User user);

    //    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id =#{id}")
//    void update(User user);

    //    @Delete("DELETE FROM user WHERE id =#{id}")
//    void delete(String id);

    List<User> getAll(@Param("orgUri") String orgUri, @Param("userType") User.Type userType, @Param("groupId") String groupId);

}

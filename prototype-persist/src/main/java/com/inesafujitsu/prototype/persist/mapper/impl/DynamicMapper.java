package com.inesafujitsu.prototype.persist.mapper.impl;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicMapper {

    //    @Select("SELECT * FROM ${table} ${where}")
    List<Map<String, Object>> getAll(Map<String, Object> entity);

    @Select("SELECT * FROM ${table} WHERE id = #{id}")
    Map<String, Object> getOne(Map<String, Object> entity);

    //    @Insert("INSERT INTO ${table}($columns) VALUES(${values})")
    void insert(Map<String, Object> entity);

    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id =#{id}")
    void update(Map<String, Object> entity);

    @Delete("DELETE FROM ${table} WHERE id =#{id}")
    void delete(Map<String, Object> entity);

}

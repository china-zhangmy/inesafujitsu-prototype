package com.inesafujitsu.prototype.persist.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface HelloWorldMapper {

    Map<String, String> checkDatabase();

}

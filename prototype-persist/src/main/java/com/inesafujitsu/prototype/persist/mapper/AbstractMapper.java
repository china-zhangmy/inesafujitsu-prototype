package com.inesafujitsu.prototype.persist.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbstractMapper<T> {

    List<T> getAll();

    T getOne(Long id);

    void insert(T entity);

    void update(T entity);

    void delete(Long id);

}

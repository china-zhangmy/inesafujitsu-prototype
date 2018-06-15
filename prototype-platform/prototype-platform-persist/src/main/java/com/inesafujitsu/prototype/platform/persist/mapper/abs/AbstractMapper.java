package com.inesafujitsu.prototype.platform.persist.mapper.abs;

import com.inesafujitsu.prototype.platform.commons.model.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbstractMapper<T extends Entity> {

    List<T> getAll();

    T getOne(String id);

    void insert(T entity);

    void update(T entity);

    void delete(String id);

}

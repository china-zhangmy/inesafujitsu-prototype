package com.inesafujitsu.prototype.platform.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AbstractService<T> {

    List<T> getAll();

    T getOne(String id);

    void insert(T entity);

    void update(T entity);

    void delete(String id);

}

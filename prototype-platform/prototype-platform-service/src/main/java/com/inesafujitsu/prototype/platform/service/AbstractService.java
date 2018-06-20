package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;

import java.util.List;

public abstract class AbstractService<T> implements IService<T> {

    protected abstract AbstractMapper<T> getMapper();

    @Override
    public List<T> getAll() {
        return getMapper().getAll();
    }

    @Override
    public T getOne(String id) {
        return getMapper().getOne(id);
    }

    @Override
    public void insert(T entity) {
        getMapper().insert(entity);
    }

    @Override
    public void update(T entity) {
        getMapper().update(entity);
    }

    @Override
    public void delete(String id) {
        getMapper().delete(id);
    }
}

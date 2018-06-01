package com.inesafujitsu.prototype.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AbstractService<T> {

    T getOne(String id);

}

package com.inesafujitsu.prototype.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RelationService {

    void bind(String xEntityName, String xId, String yEntityName, String yId);

    void unbind(String xEntityName, String xId, String yEntityName, String yId);

}

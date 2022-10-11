package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.Base;

import java.util.List;

public interface BaseService<T extends Base> {
    T get(Long id);

    List<T> getAll();

    void save(T entity);

}

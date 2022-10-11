package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.Base;
import com.ardasahin81.javachallenge.repository.BaseRepository;
import lombok.Data;

import java.util.List;

@Data
public class BaseServiceImpl<T extends Base, R extends BaseRepository<T>> implements BaseService<T> {

    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T get(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public void save(T entity) {
        getRepository().save(entity);
    }
}

package com.ardasahin81.javachallenge.repository;

import com.ardasahin81.javachallenge.domain.Base;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends CrudRepository<T, Long> {
}
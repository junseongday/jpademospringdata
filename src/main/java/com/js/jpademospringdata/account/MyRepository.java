package com.js.jpademospringdata.account;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {
    <E extends T>E save(@NonNull E comment);

    List<T> findAll();

    long count();

    @Nullable
    <E extends T> Optional<E> findById(Long id);
}

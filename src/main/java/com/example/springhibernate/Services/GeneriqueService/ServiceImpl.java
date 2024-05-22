package com.example.springhibernate.Services.GeneriqueService;


import com.example.springhibernate.Repository.Generetic.Generer;
import java.util.List;

import com.example.springhibernate.Repository.Generetic.GenererImpl;


public class ServiceImpl<T, Long> implements Generer<T, Long> {

    private final GenererImpl<T,Long> entityclass;

    public ServiceImpl(GenererImpl<T,Long> entityclass) {
        this.entityclass=entityclass;
    }

    @Override
    public List<T> findAll() {
        return entityclass.findAll();
    }

    @Override
    public T save(T entity) {
        return entityclass.save(entity);
    }

    @Override
    public T update(T entity) {
        return entityclass.save(entity);
    }

    @Override
    public T findById(Long id) {
        return entityclass.findById(id);
    }

    @Override
    public void delete(Long id) {
        entityclass.delete(id);
    }
}
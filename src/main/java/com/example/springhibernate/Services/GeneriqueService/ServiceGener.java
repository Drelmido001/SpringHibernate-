package com.example.springhibernate.Services.GeneriqueService;

import java.util.List;

public interface ServiceGener <T ,Long >{
        List<T> findAll();
        T save(T entity);
        T update(T entity);
        T findById(Long id);
        void delete(Long id);
}

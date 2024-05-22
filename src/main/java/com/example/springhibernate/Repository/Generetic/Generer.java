package com.example.springhibernate.Repository.Generetic;


import java.util.List;

public interface Generer<T, ID> {
     List<T> findAll();
     T save(T entity);
     T update(T entity);
     T findById(ID id);
     void delete(ID id);
}
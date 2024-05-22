package com.example.springhibernate.Repository.Generetic;

import com.example.springhibernate.ConfigHibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenererImpl<T,Long> implements Generer<T ,Long>{
    private final Class<T> entityClass;
    Transaction transaction=null;
    public GenererImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
    try(Session session= HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return entity;
    }catch (Exception e) {
    if(transaction!=null){
        transaction.rollback();
    }
    e.printStackTrace();
    return null;
    }
    }

    @Override
    public void  delete(Long id) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity=session.get(entityClass,(Serializable) id);
            if(entity!=null){
            session.delete(entity);
            transaction.commit();
            }else{
                System.out.println("Error : L'Id ne se trouve pas");
            }

        }catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public T update(T entity) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return entity;
        }catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(Long id) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass,(Serializable) id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(entityClass);
            criteria.from(entityClass);
            result = session.createQuery(criteria).getResultList();
        }catch (Exception e) {
            System.out.println("Erreur d'affichage");
        }
        System.out.println("data" + result.stream().map(
                t -> t.toString()
        ) );
        return result;
    }
}

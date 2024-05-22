package com.example.springhibernate.Repository;

import com.example.springhibernate.ConfigHibernate.HibernateUtil;
import com.example.springhibernate.Models.InformationPerso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class InfoPersoRepo {
    Transaction transaction=null;

    public List<InformationPerso> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM InformationPerso", InformationPerso.class).list();
        }
    }

    public InformationPerso findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query=session.createQuery("FROM InformationPerso r where r.id=:id");
            query.setParameter("id",id);
            return (InformationPerso) query.getSingleResult();
        }
    }

    public String deleteById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            InformationPerso resume=session.get(InformationPerso.class,id);
            if (resume!=null){
                session.delete(resume);
                transaction.commit();
                return "Information with id "+id+" deleted successfully";
            }else {
                return "Information not found ";
            }
        }catch (Exception msg){
            if (transaction!=null){
                transaction.rollback();
            }
            msg.printStackTrace();
            return "????  ERRO ????";
        }
    }


    public InformationPerso save(InformationPerso information){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(information);
            transaction.commit();
            return information;
        }catch (Exception msg){
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

    public InformationPerso update(InformationPerso information){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(information);
            transaction.commit();
            return information;
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

}

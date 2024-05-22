package com.example.springhibernate.Repository;

import com.example.springhibernate.ConfigHibernate.HibernateUtil;
import com.example.springhibernate.Models.Cv;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class CvRepo {
    Transaction transaction=null;

    public List<Cv> findAll(){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Cv", Cv.class).list();
        }
    }

    public Cv findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query=session.createQuery("FROM Cv r where r.id=:id");
            query.setParameter("id",id);
            return (Cv) query.getSingleResult();
        }
    }

    public String deleteById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            Cv resume=session.get(Cv.class,id);
            if (resume!=null){
                session.delete(resume);
                transaction.commit();
                return "Resume with id "+id+" deleted successfully";
            }else {
                return "Resume not found ";
            }
        }catch (Exception msg){
            if (transaction!=null){
                transaction.rollback();
            }
            msg.printStackTrace();
            return "????  ERRO ????";
        }
    }


    public Cv save(Cv resume){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(resume);
            transaction.commit();
            return resume;
        }catch (Exception msg){
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

    public Cv update(Cv resume){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(resume);
            transaction.commit();
            return resume;
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

}

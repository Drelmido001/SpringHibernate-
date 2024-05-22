package com.example.springhibernate.Repository;

import com.example.springhibernate.ConfigHibernate.HibernateUtil;
import com.example.springhibernate.Models.Competance;
import com.example.springhibernate.Models.Entreprise;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class CompetanceRepo {
    Transaction transaction=null;

    public List<Competance> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Competance", Competance.class).list();
        }
    }

    public Competance findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query=session.createQuery("FROM Competance r where r.id=:id");
            query.setParameter("id",id);
            return (Competance) query.getSingleResult();
        }
    }

    public String deleteById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            Competance resume=session.get(Competance.class,id);
            if (resume!=null){
                session.delete(resume);
                transaction.commit();
                return "Skills with id "+id+" deleted successfully";
            }else {
                return "Skills not found ";
            }
        }catch (Exception msg){
            if (transaction!=null){
                transaction.rollback();
            }
            msg.printStackTrace();
            return "????  ERRO ????";
        }
    }


    public Competance save(Competance skills){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(skills);
            transaction.commit();
            return skills;
        }catch (Exception msg){
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

    public Competance update(Competance skills){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(skills);
            transaction.commit();
            return skills;
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

}

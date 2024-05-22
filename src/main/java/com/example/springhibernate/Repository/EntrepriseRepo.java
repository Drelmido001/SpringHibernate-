package com.example.springhibernate.Repository;

import com.example.springhibernate.ConfigHibernate.HibernateUtil;
import com.example.springhibernate.Models.Entreprise;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class EntrepriseRepo {
    public Entreprise update(Entreprise companies) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(companies);
            transaction.commit();
            return companies;
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }

    Transaction transaction = null;

    public List<Entreprise> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Entreprise", Entreprise.class).list();
        }
    }

    public Entreprise findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Entreprise r where r.id=:id");
            query.setParameter("id", id);
            return (Entreprise) query.getSingleResult();
        }
    }

    public String deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Entreprise resume = session.get(Entreprise.class, id);
            if (resume != null) {
                session.delete(resume);
                transaction.commit();
                return "Companies with id " + id + " deleted successfully";
            } else {
                return "Companies not found ";
            }
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return "????  ERRO ????";
        }
    }


    public Entreprise save(Entreprise companies) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(companies);
            transaction.commit();
            return companies;
        } catch (Exception msg) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg.printStackTrace();
            return null;
        }
    }
}

package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestRepository {

//  TASK 13-c
    public void save(Guest guest) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(guest);
            transaction.commit();
//            System.out.println("The Guest is saved successfully!");   // done with the postPersist method in Room Entity
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    private Session session;
//    TASK 9-c:
    public Guest findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Guest.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

//    TASK 10-c:
    public List<Guest> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("FROM Guest", Guest.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}

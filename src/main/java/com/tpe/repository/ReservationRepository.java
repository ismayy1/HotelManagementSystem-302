package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import com.tpe.domain.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepository {

    private Session session;

//  TASK 15-c:
    public void save(Reservation reservation) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
//            System.out.println("The Reservation is saved successfully!");   // done with the postPersist method in Room Entity
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

//    TASK 11-c:
    public Reservation findByID(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Reservation.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

//    TASK 12-c:
    public List<Reservation> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("FROM Reservation", Reservation.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

//    TASK 16-c:
    public void delete(Reservation reservation) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
//            System.out.println("The Reservation is saved successfully!");   // done with the postPersist method in Room Entity
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}

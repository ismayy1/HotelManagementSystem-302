package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepository {

    private Session session;

//    TASK 1-b:
    public void save(Hotel hotel) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(hotel);

            transaction.commit();
//            System.out.println("The Hotel is saved successfully!");   // done with the postPersist method in Hotel Entity
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

//    TASK 2-b:
    public Hotel findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Hotel.class, id);

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}

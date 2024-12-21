package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import com.tpe.domain.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ReservationRepository {

    private Session session;

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
}

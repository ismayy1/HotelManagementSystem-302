package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GuestRepository {

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
}

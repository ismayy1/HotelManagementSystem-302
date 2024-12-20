package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    private Session session;

    public void save(Room room) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
//            System.out.println("The Room is saved successfully!");   // done with the postPersist method in Room Entity
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }


    public Room findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Room.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Room> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
//            String hql = "FROM Room";
//            return session.createQuery(hql, Room.class).getResultList();
            return session.createQuery("FROM Room", Room.class).getResultList();  // faster way
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}

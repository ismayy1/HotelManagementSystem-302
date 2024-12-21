package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

//    TASK 3-b: findAll
    public List<Hotel> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
//            String hql = "FROM Hotel";
//            return session.createQuery(hql, Hotel.class).getResultList();
            return session.createQuery("FROM Hotel", Hotel.class).getResultList();  // faster way
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //    TASK 17-c:
    public void update(Hotel hotel) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(hotel);
            transaction.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Hotel hotel) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(hotel);
            transaction.commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}

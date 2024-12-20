package com.tpe.config;

//import com.tpe.domain.*;  // fast way to import all the classes from the same package
import com.tpe.domain.Guest;
import com.tpe.domain.Hotel;
import com.tpe.domain.Reservation;
import com.tpe.domain.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Hotel.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Reservation.class)
                    .addAnnotatedClass(Guest.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Initialization of sessionFactory failed!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() { // when we exit the app, we'll also call this method
        getSessionFactory().close();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {  // here we have a session that we can close
            session.close();
        }
    }
}

package com.globallogic.dbhelper;

import com.globallogic.dto.UserBan;
import com.globallogic.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by limmy on 19.03.17.
 */
public class DataSender {
    private SessionFactory sessionFactory;
    public DataSender() {
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(UserBan.class)
                .buildSessionFactory();
    }
    public void sendData(Object... objects) {
        Session session = sessionFactory.openSession();
        if (session.isConnected()) {

            System.out.println("ALL IS GOOD");
            session.beginTransaction();

            for (Object user: objects) {
                session.save(user);
            }

            session.getTransaction().commit();
            session.close();
            System.out.println("Connection is closed");
        }

        sessionFactory.close();
    }

}

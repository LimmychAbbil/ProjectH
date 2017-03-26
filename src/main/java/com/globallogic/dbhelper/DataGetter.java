package com.globallogic.dbhelper;

import com.globallogic.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Limmy on 26.03.2017.
 */
public class DataGetter {
    private SessionFactory sessionFactory;
    public UserDetails getData(int userId) {
        UserDetails user = null;

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if (session.isConnected()) {
            System.out.println("READY TO READ");
            session.beginTransaction();
             user = (UserDetails) session.get(UserDetails.class, userId);
            System.out.println(user.getUsername() + " read");
            session.close();
            System.err.println("Connection is closed");
        }

        sessionFactory.close();

        return user;
    }
}

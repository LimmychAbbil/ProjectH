package main.java.com.globallogic.dbhelper;

import main.java.com.globallogic.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by limmy on 19.03.17.
 */
public class DataSender {
    private SessionFactory sessionFactory;
    public DataSender() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public void sendData(UserDetails user) {
        Session sesssion = sessionFactory.openSession();
        if (sesssion.isConnected()) {
            System.out.println("ALL IS GOOD");
            sesssion.beginTransaction();
            sesssion.save(user);

            sesssion.getTransaction().commit();
            sesssion.close();
            System.err.println("Connection is closed");
        }

        sessionFactory.close();
    }

}

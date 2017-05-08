package com.globallogic.dbhelper;

import com.globallogic.dto.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Limmy on 30.04.2017.
 */
public class DataHelper {
    private SessionFactory sessionFactory;
    private Session session;
    public DataHelper() {
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(UserBan.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(OpenGroup.class)
                .addAnnotatedClass(ClosedGroup.class)
                .buildSessionFactory();

        session = sessionFactory.openSession();
    }
    public void sendData(Object... objects) {
        if (session.isConnected()) {

            session.beginTransaction();

            for (Object user: objects) {
                session.save(user);
            }

            session.getTransaction().commit();
        }
        else throw new RuntimeException("Can't insert objects " + objects.toString());
    }

    public Object getData(Class objectClass, int objectId) {
        Object o = null;

        if (session.isConnected()) {
            session.beginTransaction();
            o = session.get(objectClass, objectId);
            session.getTransaction().commit();
        }
        else throw new RuntimeException("Can't get object by id" + objectId);
        return o;
    }

    public void updateData(Object o) {
        if (session.isConnected()) {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        }
        else throw new RuntimeException("Can't updatr object " + o.toString());

    }

    public void deleteData(Object o) {
        if (session.isConnected()) {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        }
        else throw new RuntimeException("Can't delete object " + o.toString());
    }

    public List<UserDetails> query() {
        if (session.isConnected()) {
            session.beginTransaction();
            Query query = session.createQuery("from UserDetails");
            List<UserDetails> list = query.list();
            return list;
        }
        return null;
    }

    public void close() {
        session.close();
        sessionFactory.close();
    }
}

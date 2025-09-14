package DAO;

import HibernateSessionFactory.HibernateSessionFactory;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Optional;

public class UserDAOImpl implements UserDAO<User> {

    @Override
    public Optional<User> read(int id) {
        return Optional.ofNullable(HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id));
    }

    @Override
    public User create(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
        return user;
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(user);
        tx1.commit();
        session.close();
    }

}

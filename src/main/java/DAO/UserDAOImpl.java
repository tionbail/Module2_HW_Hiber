package DAO;

import HibernateSessionFactory.HibernateSessionFactory;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAOImpl implements CommonDAO<User> {

    @Override
    public User read(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public User create(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
        Transaction tx1 = session.beginTransaction();
            session.persist(user);
            tx1.commit();
            return user;
        }

    }

    @Override
    public User update(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            User mergedUser = session.merge(user);
            tx.commit();
            return mergedUser;
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.remove(user);
            tx1.commit();
        }
    }

    public void delete(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx1.commit();
        }
    }

}

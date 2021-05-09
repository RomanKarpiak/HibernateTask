package com.roman.daoImpl;

import com.roman.dao.CartDAO;
import com.roman.entity.Cart;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CartDAOImpl implements CartDAO {

    private final SessionFactory factory;

    public CartDAOImpl() {this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Cart cart) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(cart);
            session.getTransaction().commit();
        }

    }

    @Override
    public Cart read(Long id) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            Cart result = session.get(Cart.class,id);
            return result;
        }
    }

    @Override
    public void updateCart(Cart cart) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(cart);
            session.getTransaction().commit();
        }


    }

    @Override
    public void deleteCart(Cart cart) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(cart);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Cart> findAll() {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select c from Cart c");
            return (List<Cart>) query.getResultList();
        }

    }
}

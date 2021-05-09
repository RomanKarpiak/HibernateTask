package com.roman.daoImpl;

import com.roman.dao.CartProductDAO;
import com.roman.entity.CartProduct;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CartProductDAOImpl implements CartProductDAO {
    private final SessionFactory factory;

    public CartProductDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void createCartProduct(CartProduct cartProduct) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(cartProduct);
            session.getTransaction().commit();
        }

    }

    @Override
    public CartProduct read(Long id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            CartProduct result = session.get(CartProduct.class,id);
            return result;
        }

    }

    @Override
    public void updateCartProduct(CartProduct cartProduct) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(cartProduct);
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteCartProduct(CartProduct cartProduct) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(cartProduct);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<CartProduct> findAll() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select cp from CartProduct cp");
            return (List<CartProduct>) query.getResultList();
        }

    }
}

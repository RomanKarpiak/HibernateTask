package com.roman.daoImpl;

import com.roman.HibernateUtil;
import com.roman.dao.ProductDAO;
import com.roman.entity.Product;
import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final SessionFactory factory;

    public ProductDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

@Override
    public void create(@NotNull final Product product) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            System.out.println("Saving the customer...");
            session.save(product);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    @Override
    public Product read(@NotNull final Long id) {
        try (final Session session = factory.openSession()) {
            final Product result = session.get(Product.class, id);
            return result != null ? result : new Product();
        }
    }

    @Override
    public void updateProduct(@NotNull final Product product) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(product);

            session.getTransaction().commit();
        }
    }


    @Override
    public void deleteProduct(@NotNull final Product product) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(product);

            session.getTransaction().commit();
        }
    }
    @Override
    public List<Product> findAll() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select p from Product p");
            List<Product> products = (List<Product>) query.getResultList();
            return products;
        }
    }
}

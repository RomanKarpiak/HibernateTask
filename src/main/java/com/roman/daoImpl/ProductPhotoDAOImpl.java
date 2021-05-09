package com.roman.daoImpl;

import com.roman.dao.ProductPhotoDao;
import com.roman.entity.ProductPhoto;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ProductPhotoDAOImpl implements ProductPhotoDao {

    private final SessionFactory factory;

    public ProductPhotoDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(ProductPhoto productPhoto) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(productPhoto);
            session.getTransaction().commit();
        }

    }

    @Override
    public ProductPhoto read(Long id) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            ProductPhoto productPhoto = session.get(ProductPhoto.class, id);
            return productPhoto != null ? productPhoto : new ProductPhoto();
        }
    }

    @Override
    public void updateProductPhoto(ProductPhoto productPhoto) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(productPhoto);

            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(ProductPhoto productPhoto) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(productPhoto);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<ProductPhoto> findAll() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select pp from ProductPhoto pp");
            return (List<ProductPhoto>) query.getResultList();
        }

    }
}

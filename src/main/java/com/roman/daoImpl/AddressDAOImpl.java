package com.roman.daoImpl;

import com.roman.dao.AddressDAO;
import com.roman.entity.Address;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

    private final SessionFactory factory;

    public AddressDAOImpl() {this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Address address) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }

    }

    @Override
    public Address read(Long id) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            return session.get(Address.class,id);
        }
    }

    @Override
    public void updateAddress(Address address) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteAddress(Address address) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(address);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Address> findAll() {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select a from Address a");
            return (List<Address>)query.getResultList();
        }
    }
}

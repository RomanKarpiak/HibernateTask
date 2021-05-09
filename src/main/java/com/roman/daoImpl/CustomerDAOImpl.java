package com.roman.daoImpl;

import com.roman.dao.CustomerDAO;
import com.roman.entity.Customer;
import com.roman.util.HibernateUtil;
import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory factory;
    private Transaction transaction = null;

    public CustomerDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(@NotNull final Customer customer) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            System.out.println("Saving the customer...");
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    @Override
    public Customer read(@NotNull final Long id) {
        try (final Session session = factory.openSession()) {
            final Customer result = session.get(Customer.class, id);
            return result != null ? result : new Customer();
        }

    }

    @Override
    public void updateCustomer(@NotNull final Customer customer) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(customer);

            session.getTransaction().commit();
        }
    }


    @Override
    public void deleteCustomer(@NotNull final Customer customer) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(customer);

            session.getTransaction().commit();
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select c from Customer c");
            List<Customer> customers = (List<Customer>) query.getResultList();
            return customers;
        }
    }
}

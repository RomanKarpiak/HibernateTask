package com.roman;

import com.roman.dao.CustomerDAO;
import com.roman.daoImpl.CustomerDAOImpl;
import com.roman.entity.Customer;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        List<Customer> customers = customerDAO.findAll();
        for (Customer c:customers) {
            System.out.println(c);
        }
        HibernateUtil.shutdown();

    }
}

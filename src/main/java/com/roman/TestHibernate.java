package com.roman;

import com.roman.dao.CustomerDAO;
import com.roman.daoImpl.CustomerDAOImpl;
import com.roman.entity.Customer;
import com.roman.util.HibernateUtil;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        Customer customer = customerDAO.read(1L);
        System.out.println(customer);



        HibernateUtil.shutdown();

    }
}

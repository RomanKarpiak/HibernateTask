package com.roman;

import com.roman.dao.ProductDAO;
import com.roman.daoImpl.ProductDAOImpl;
import com.roman.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//        Customer customer = customerDAO.read(1L);
//        System.out.println(customer.getName());
//        List<Customer> customers = customerDAO.findAll();
//        for (Customer c:customers) {
//            System.out.println(c);
//        }
        ProductDAO productDAO = new ProductDAOImpl();
        Product product = new Product();
        List<Product> products = productDAO.findAll();
        for (Product p:products) {
            System.out.println(p);

        }

        HibernateUtil.shutdown();

    }
}

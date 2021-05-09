package com.roman;

import com.roman.util.HibernateUtil;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();



        HibernateUtil.shutdown();

    }
}

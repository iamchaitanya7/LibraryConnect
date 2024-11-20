package com.jbk.config;

import com.jbk.entities.Author;
import com.jbk.entities.Book;
import com.jbk.entities.Borrower;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory getSessionFactory () {
        Configuration cfg = new Configuration ( );
        cfg.configure ( ).addAnnotatedClass (Book.class).addAnnotatedClass (Author.class).addAnnotatedClass (Borrower.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory ( );
        return sessionFactory;
    }
}

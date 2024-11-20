package com.jbk.operations;

import com.jbk.config.HibernateUtil;
import com.jbk.entities.Book;
import com.jbk.entities.Borrower;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class dbOperations {

    public void addEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        System.out.println("Entity added successfully!");
    }

    public <T> T getEntityById(Class<T> entityClass, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    public void updateEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        System.out.println("Entity updated successfully!");
    }

    public void deleteEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
        System.out.println("Entity deleted successfully!");
    }

    public <T> List<T> getAllEntities(Class<T> entityClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = session.createCriteria(entityClass).list();
        session.close();
        return entities;
    }

    //Fetch all books by a specific author using Restrictions.
    public List<Book> fetchBooksByAuthor(int authorId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createCriteria(Book.class).add(Restrictions.eq("author.id", authorId)).list();
        session.close();
        return books;
    }

    //List all borrowers of a particular book using Restrictions
    public List<Borrower> fetchBorrowersByBook(int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Borrower> borrowers = session.createCriteria(Borrower.class).createAlias("books", "b").add(Restrictions.eq("b.id", bookId)).list();
        session.close();
        return borrowers;
    }

    //Retrieve the most expensive book using Projections.
    public Book fetchMostExpensiveBook() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Retrieve the maximum price.
        Double maxPrice = (Double) session.createCriteria(Book.class).setProjection(Projections.max("price")).uniqueResult();
        //Find the book with the maximum price
        Book book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("price", maxPrice)).uniqueResult();
        session.close();
        return book;
    }

    //Fetch all books whose title contains a specific keyword using Restrictions with Like.
    public List<Book> fetchBooksByTitleKeyword(String keyword) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createCriteria(Book.class).add(Restrictions.like("title", "%" + keyword + "%")).list();
        session.close();
        return books;
    }
}


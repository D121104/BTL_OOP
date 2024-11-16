/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import java.util.List;

/**
 *
 * @author ddd
 */
public class BookDAO {

    // them sach
    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat sach
    public void updateBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // xoa sach theo id
    public void deleteBookbById(int bookId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                session.delete(book);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay sach bang id
    public Book getBookById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // lay sach theo ten
    @SuppressWarnings("unchecked")
    public List<Book> getBookByName(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where title = :title";
            return session.createQuery(hql).setParameter("title", title).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     // lay sach theo 1 phan ten
    @SuppressWarnings("unchecked")
    public List<Book> getBookByPartialName(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where title like :title";
            return session.createQuery(hql).setParameter("title", "%" + title + "%").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // lay sach theo the loai
    @SuppressWarnings("unchecked")
        public List<Book> getBookByCategory(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where category = :category";
            return session.createQuery(hql).setParameter("category", category).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    // lay sach theo 1 phan the loai
    @SuppressWarnings("unchecked")
        public List<Book> getBookByPartialCategory(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where category like :category";
            return session.createQuery(hql).setParameter("category", "%" + category + "%").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    // lay sach theo tac gia
    @SuppressWarnings("unchecked")
        public List<Book> getBookByAuthor(String author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where author = :author";
            return session.createQuery(hql).setParameter("author", author).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    // lay sach theo 1 phan ten tac gia
    @SuppressWarnings("unchecked")
        public List<Book> getBookByPartialAuthor(String author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where author like :author";
            return session.createQuery(hql).setParameter("author", "%" + author + "%").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    // lay sach theo nha xuat ban
    @SuppressWarnings("unchecked")
        public List<Book> getBookByPublisher(Publisher publisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where publisher = :publisher";
            return session.createQuery(hql).setParameter("publisher", publisher).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay sach theo 1 phan nha xuat ban
    @SuppressWarnings("unchecked")
        public List<Book> getBookByPartialPublisher(Publisher publisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where publisher like :publisher";
            return session.createQuery(hql).setParameter("publisher", "%" + publisher + "%").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }        
        
    // lay sach theo nam xuat ban
    @SuppressWarnings("unchecked")
        public List<Book> getBookByYearPublisher(int yearPublisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Book where yearPublisher = :yearPublisher";
            return session.createQuery(hql).setParameter("yearPublisher", yearPublisher).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    // lay tat ca sach
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("from Book");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}

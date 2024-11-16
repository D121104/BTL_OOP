/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.Publisher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import java.util.List;

/**
 *
 * @author ddd
 */
public class PublisherDAO {

    // them publishher
    public void savePublisher(Publisher publisher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(publisher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat publisher
    public void updatePublisher(Publisher publisher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(publisher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // xoa publisher theo id
    public void deletePublisherById(int publisherId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Publisher publisher = session.get(Publisher.class, publisherId);
            if (publisher != null) {
                session.delete(publisher);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay publisher theo id
    public Publisher getPublisherById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Publisher.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay publisher theo ten
    @SuppressWarnings("unchecked")
        public List<Publisher> getPublisherByName(String publisherName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Publisher where publisherName = :publisherName";
            return session.createQuery(hql).setParameter("publisherName", publisherName).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // lay tat ca publisher
    @SuppressWarnings("unchecked")
    public List<Publisher> getAllPublishers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Publisher").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;

import java.util.List;
/**
 *
 * @author ddd
 */
public class CategoryDAO {

    // them category
    public void saveCategory(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat category thong qua id
    public void updateCategory(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // xoa category
    public void deleteCategoryById(int categoryId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Category category = session.get(Category.class, categoryId);
            if (category != null) {
                session.delete(category);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay category theo id
    public Category getCategoryById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // lay category theo ten
    @SuppressWarnings("unchecked")
    public List<Category> getCategoryByName(String categoryName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Category where categoryName = :catName";
            return session.createQuery(hql).setParameter("catName", categoryName).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // lay tat ca category
    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Category").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

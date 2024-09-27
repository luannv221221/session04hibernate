package com.ra.model.dao;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Category", Category.class).list();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    @Override
    public Boolean save(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception){
            session.getTransaction().rollback();
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}

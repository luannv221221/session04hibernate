package com.ra.model.service;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public Boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDAO.delete(id);
    }
}

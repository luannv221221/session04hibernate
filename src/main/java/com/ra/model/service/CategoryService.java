package com.ra.model.service;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Boolean save(Category category);
    Category findById(int id);
    Boolean update(Category category);
    void delete(int id);
}

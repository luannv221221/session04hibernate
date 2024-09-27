package com.ra.model.dao;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Boolean save(Category category);
    Category findById(int id);
    Boolean update(Category category);


}

package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/category")
    public String category(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "category";
    }
    @GetMapping("/category-add")
    public String add(){
        return "add-category";
    }
    @PostMapping("/category-add")
    public String save(HttpServletRequest httpServletRequest){
        // lay du lieu tu form
        String name = httpServletRequest.getParameter("name");
        boolean status = Boolean.parseBoolean(httpServletRequest.getParameter("status"));
        // khoi tao doi tuong category
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryStatus(status);

        // goi den service de them moi
        if(categoryService.save(category)){
            return "redirect:/category";
        }
        return "redirect:/category-add";
    }

    @GetMapping("/category-edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "edit-category";
    }
    @PostMapping("/category-edit/{id}")
    public String update(@PathVariable("id") int id,HttpServletRequest httpServletRequest){
        // lay du lieu tu form
        String name = httpServletRequest.getParameter("name");
        boolean status = Boolean.parseBoolean(httpServletRequest.getParameter("status"));
        // khoi tao doi tuong category
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryStatus(status);
        // set id lay duoc tu url
        category.setCategoryId(id);
        // goi den service de cap nhat
        if(categoryService.update(category)){
            return "redirect:/category";
        }
        return "redirect:/category-edit"+id;

    }
}

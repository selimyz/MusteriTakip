package com.selim.musteritakip.service;

import com.selim.musteritakip.repository.CategoryRepository;
import com.selim.musteritakip.repository.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public void save(Category category) {
        repository.save(category);
    }

    public void update(Category category) {
        repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public List<Category> findByParentId(long id) {
        return repository.findByParentid(id);
    }
}

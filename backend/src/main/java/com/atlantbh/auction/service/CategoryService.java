package com.atlantbh.auction.service;

import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<Category, Long , CategoryRepository> {

    public List<Category> findCategories() {
        return repository.findAll();
    }
}

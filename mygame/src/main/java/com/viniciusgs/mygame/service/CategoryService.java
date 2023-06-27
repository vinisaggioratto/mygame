package com.viniciusgs.mygame.service;

import com.viniciusgs.mygame.entity.Category;
import com.viniciusgs.mygame.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //pesquisar as categorias
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //salvar uma nova categoria
    public Category save(Category category){
        categoryRepository.save(category);
        return new Category();
    }
}

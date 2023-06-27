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
import java.util.Optional;

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

    //pesquisar as categorias por id
    public Category findById(long id){
        Optional<Category> optional = categoryRepository.findById(id);

        if(!optional.isPresent()){
            throw new RuntimeException("Category not found.");
        }
        Category category = optional.get();
        return new Category();
    }

    //atualizar uma category
    public Category update(Category category){
        Optional<Category> userToEdit = categoryRepository.findById(category.getId());

        if(!userToEdit.isPresent()){
            throw new RuntimeException("Category not found.");
        }
        categoryRepository.save(category);
        return new Category();
    }

    //delete a category
    public void deleteById(long id){
        categoryRepository.deleteById(id);

    }
}

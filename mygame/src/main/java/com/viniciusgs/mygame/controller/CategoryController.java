package com.viniciusgs.mygame.controller;

import com.viniciusgs.mygame.entity.Category;
import com.viniciusgs.mygame.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(@Autowired CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping()  //cadastrar uma categoria
    public ResponseEntity post(@RequestBody Category category) {
        try {
            return new ResponseEntity(categoryService.save(category), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody Category category) {

        try {
            return new ResponseEntity<>(categoryService.update(category), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>("Categoria removida com sucesso", HttpStatus.OK);
        } catch (EmptyResultDataAccessException error) {
            return new ResponseEntity("Não foi possível localizar a categoria.", HttpStatus.BAD_REQUEST);
        } catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

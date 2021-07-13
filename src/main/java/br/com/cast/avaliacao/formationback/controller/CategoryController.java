package br.com.cast.avaliacao.formationback.controller;

import br.com.cast.avaliacao.formationback.model.Category;
import br.com.cast.avaliacao.formationback.model.Course;
import br.com.cast.avaliacao.formationback.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CategoryController {

    CategoryRepository repository;

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return repository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category categoryById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        return repository.save(category);
    }
}

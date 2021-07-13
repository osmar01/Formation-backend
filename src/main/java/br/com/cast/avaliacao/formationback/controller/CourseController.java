package br.com.cast.avaliacao.formationback.controller;

import br.com.cast.avaliacao.formationback.model.Course;
import br.com.cast.avaliacao.formationback.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CourseController {

    CourseRepository repository;

    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return repository.findAll();
    }

    @GetMapping("/course/{id}")
    public Course courseById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        return repository.save(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity update(@PathVariable("id") long id,  @RequestBody Course course) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescription(course.getDescription());
                    record.setQtd(course.getQtd());
                    record.setDateInit(course.getDateInit());
                    record.setDateFinal(course.getDateFinal());
                    record.setCategory(course.getCategory());

                    Course updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}

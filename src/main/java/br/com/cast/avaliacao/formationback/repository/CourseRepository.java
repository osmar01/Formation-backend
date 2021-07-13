package br.com.cast.avaliacao.formationback.repository;

import br.com.cast.avaliacao.formationback.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

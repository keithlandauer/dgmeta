package dev.keithlandauer.dgmeta.layout;

import dev.keithlandauer.dgmeta.course.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LayoutRepository extends JpaRepository<Layout, Integer> {
   Optional<Layout> findById(Integer id);

   Optional<List<Layout>> findByCourse(Course course);
}

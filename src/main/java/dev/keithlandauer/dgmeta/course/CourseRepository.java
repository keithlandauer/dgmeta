package dev.keithlandauer.dgmeta.course;
import org.springframework.data.jpa.repository.JpaRepository;  
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findCourseById(Integer id);
    
}

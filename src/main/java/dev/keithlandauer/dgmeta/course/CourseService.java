package dev.keithlandauer.dgmeta.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public List<Course> allCourses() {
        return courseRepo.findAll();
    }

    public Optional<Course> findSingleCourse(Integer id) {
        return courseRepo.findCourseById(id);
    }

    public Course createCourse(String name, Integer max_holes) {

        Course course = courseRepo.save(new Course(name, max_holes));

        return course;
    }

}

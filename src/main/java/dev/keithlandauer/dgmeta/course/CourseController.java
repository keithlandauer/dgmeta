package dev.keithlandauer.dgmeta.course;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> allCourses() {
        return new ResponseEntity<List<Course>>(courseService.allCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getSingleCourse(@PathVariable Integer id) {
        return new ResponseEntity<Optional<Course>>(courseService.findSingleCourse(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course payload) {
        return new ResponseEntity<Course>(courseService.createCourse(payload.getName(), payload.getMax_holes()),
                HttpStatus.CREATED);
    }

}

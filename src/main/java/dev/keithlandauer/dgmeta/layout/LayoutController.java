package dev.keithlandauer.dgmeta.layout;

import dev.keithlandauer.dgmeta.course.Course;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/layouts")
public class LayoutController {

    @Autowired
    private LayoutService layoutService;

    @GetMapping
    public ResponseEntity<List<Layout>> allLayouts() {
        return new ResponseEntity<List<Layout>>(layoutService.allLayouts(), HttpStatus.OK);
    }

    @GetMapping("/courses/{course}")
    public ResponseEntity<Optional<List<Layout>>>filterByCourse(@PathVariable Course course) {
        return new ResponseEntity<Optional<List<Layout>>>(layoutService.getByCourse(course), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Layout>> getSingleLayout(@PathVariable Integer id) {
        return new ResponseEntity<Optional<Layout>>(layoutService.findSingleLayout(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Layout> createLayout(@RequestBody Layout payload) {
        return new ResponseEntity<Layout>(layoutService.createLayout(payload.getName(),
                payload.getDifficulty(), payload.getCourse()), HttpStatus.CREATED);
    }

}

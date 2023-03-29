package dev.keithlandauer.dgmeta.layout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import dev.keithlandauer.dgmeta.course.Course;

@Service
public class LayoutService {
    @Autowired
    private LayoutRepository layoutRepo;

    public Layout createLayout(String name, List<Integer> difficulty, Course course_id) {

        Layout layout = layoutRepo.save(new Layout(name, difficulty, course_id));

        return layout;
    }

    public List<Layout> allLayouts() {
        return layoutRepo.findAll();
    }

    public Optional<Layout> findSingleLayout(Integer id) {
        return layoutRepo.findById(id);
    }

    public Optional<List<Layout>>getByCourse(Course course) {
        return layoutRepo.findByCourse(course);
    }
}

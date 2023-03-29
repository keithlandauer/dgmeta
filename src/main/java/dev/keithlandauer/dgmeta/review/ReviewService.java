package dev.keithlandauer.dgmeta.review;
import dev.keithlandauer.dgmeta.course.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;

    public Review createReview(String text, Double rating, Course course_id) {

        Review review = reviewRepo.save(new Review(text, rating, course_id));

        return review;
    }
    
}
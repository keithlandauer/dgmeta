package dev.keithlandauer.dgmeta.review;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review payload) {
        return new ResponseEntity<Review>(
                reviewService.createReview(payload.getText(), payload.getRating(), payload.getCourse_id()),
                HttpStatus.CREATED);

    }
}
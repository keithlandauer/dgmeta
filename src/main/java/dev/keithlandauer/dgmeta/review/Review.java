package dev.keithlandauer.dgmeta.review;

import dev.keithlandauer.dgmeta.course.Course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "reviews")
public class Review {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private Double rating;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course_id;

    public Review(String text, Double rating, Course course_id) {
        this.text = text;
        this.rating = rating;
        this.course_id = course_id;
    }
    
}
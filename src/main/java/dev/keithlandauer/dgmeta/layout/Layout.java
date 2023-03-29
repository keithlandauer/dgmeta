package dev.keithlandauer.dgmeta.layout;

import java.util.List;
import java.util.ArrayList;

import dev.keithlandauer.dgmeta.course.Course;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "layouts")
public class Layout {
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
   
    @Column(name = "difficulty")
    private List<Integer> difficulty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Layout(String name, List<Integer> difficulty, Course course_id) {
        this.name = name;
        this.difficulty = new ArrayList<Integer>(difficulty);
        this.course = course_id;
    }
}

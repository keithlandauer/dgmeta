package dev.keithlandauer.dgmeta.course;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "courses")
public class Course {

    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_holes")
    private Integer max_holes;

    public Course(String name, Integer max_holes ) {
        this.name = name;
        this.max_holes = max_holes;
    }




    
}

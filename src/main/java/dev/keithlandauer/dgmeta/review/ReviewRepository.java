package dev.keithlandauer.dgmeta.review;

import org.springframework.data.jpa.repository.JpaRepository;  

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
package dev.keithlandauer.dgmeta.hole;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.keithlandauer.dgmeta.layout.Layout;


public interface HoleRepository extends JpaRepository<Hole, Integer> {

    Optional<Hole> findById(Integer id);

    Optional<List<Hole>> findByLayout(Layout layout);
}

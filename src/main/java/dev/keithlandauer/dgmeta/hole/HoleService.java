package dev.keithlandauer.dgmeta.hole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import dev.keithlandauer.dgmeta.layout.Layout;

@Service
public class HoleService {
    @Autowired
    private HoleRepository holeRepo;

    public Hole createHole(Integer par, Integer feet, List<String> tips, String imgUrl, Layout layout_id) {

        Hole hole = holeRepo.save(new Hole(par, feet, tips, imgUrl, layout_id));

        return hole;
    }

    public Hole updateHole(Hole hole){

        holeRepo.save(hole);

        return hole;
    }

    public List<Hole> allHoles() {
        return holeRepo.findAll();
    }

    public Optional<Hole> findSingleHole(Integer id) {
        return holeRepo.findById(id);
    }

    public Optional<List<Hole>> getByLayout(Layout layout) {
        return holeRepo.findByLayout(layout);
    }
}

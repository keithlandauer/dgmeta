package dev.keithlandauer.dgmeta.hole;

import org.springframework.web.bind.annotation.RestController;

import dev.keithlandauer.dgmeta.layout.Layout;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/holes")
public class HoleController {
    @Autowired
    private HoleService holeService;

    @GetMapping
    public ResponseEntity<List<Hole>> allHoles() {

        return new ResponseEntity<List<Hole>>(holeService.allHoles(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hole>> getHole(@PathVariable Integer id) {
        return new ResponseEntity<Optional<Hole>>(holeService.findSingleHole(id), HttpStatus.OK);
    }

    @GetMapping("/layouts/{layout}")
    public ResponseEntity<Optional<List<Hole>>> filterByLayout(@PathVariable Layout layout) {
        return new ResponseEntity<Optional<List<Hole>>>(holeService.getByLayout(layout), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hole> createHole(@RequestBody Hole payload) {
        return new ResponseEntity<Hole>(holeService.createHole(payload.getPar(), payload.getFeet(),
                payload.getTips(), payload.getImgUrl(), payload.getLayout()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hole> updateHole(@PathVariable Integer id, @RequestBody Hole payload) {

        Optional<Hole> tempHole = holeService.findSingleHole(id);

        tempHole.get().setPar(payload.getPar());
        tempHole.get().setFeet(payload.getFeet());
        tempHole.get().setTips(payload.getTips());
        tempHole.get().setImgUrl(payload.getImgUrl());
        tempHole.get().setLayout(payload.getLayout());

        holeService.updateHole(tempHole.get());

        return ResponseEntity.ok(tempHole.get());
    }

}

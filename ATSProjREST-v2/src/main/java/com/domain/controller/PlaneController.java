package com.domain.controller;

import com.domain.entity.Plane;
import com.domain.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlaneController {
    @Autowired
    PlaneRepository planeRepository;

    @GetMapping("/planes")
    public List<Plane> findAllPlanes() {
        List<Plane> planesList = planeRepository.findAll();
        return planesList;
    }

    @GetMapping("/planes/{plantID}")
    public Plane findPlaneById(@PathVariable(value="id") long planeId) {
        Optional<Plane> optionalPlane = planeRepository.findById(planeId);
        Plane plane = optionalPlane.get();
        return plane;
    }

    @PostMapping("/planes")
    public Plane createPlane(@RequestBody Plane plane) {
        Plane planeReturned = planeRepository.save(plane);
        return planeReturned;
    }

    @PutMapping("/planes/{id}")
    public Plane updatePlane(@PathVariable(value="id") Long planeId, @RequestBody Plane plane) {
        Optional<Plane> optionalPlane = planeRepository.findById(planeId);
        Plane planeFromDB = optionalPlane.get();
        planeFromDB.setPlaneCapacity(plane.getPlaneCapacity());
        planeFromDB.setPlaneMaker(plane.getPlaneMaker());
        planeFromDB.setPlaneModel(plane.getPlaneModel());
        planeFromDB.setPlaneRegNo(plane.getPlaneRegNo());
        Plane planeReturned = planeRepository.save(planeFromDB);
        return planeReturned;
    }

    @DeleteMapping("/planes/{id}")
    public boolean deleteProduct(@PathVariable(value="id") Long planeId) {
        planeRepository.deleteById(planeId);
        return true;
    }
}

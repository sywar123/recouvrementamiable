package com.recouvrement.controller;

import com.recouvrement.model.Structure;
import com.recouvrement.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/structures")
@CrossOrigin(origins = "*")
public class StructureController {

    @Autowired
    private StructureService service;

    @GetMapping
    public List<Structure> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Structure> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Structure create(@RequestBody Structure structure) {
        return service.create(structure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Structure> update(@PathVariable Long id, @RequestBody Structure structure) {
        Structure updated = service.update(id, structure);
        if (updated != null) return ResponseEntity.ok(updated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

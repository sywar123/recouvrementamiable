package com.recouvrement.controller;

import com.recouvrement.model.TypeStructure;
import com.recouvrement.service.TypeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-structures")
@CrossOrigin(origins = "*")
public class TypeStructureController {

    @Autowired
    private TypeStructureService service;

    @GetMapping
    public List<TypeStructure> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeStructure> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeStructure create(@RequestBody TypeStructure ts) {
        return service.create(ts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeStructure> update(@PathVariable Long id, @RequestBody TypeStructure ts) {
        TypeStructure updated = service.update(id, ts);
        if (updated != null) return ResponseEntity.ok(updated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


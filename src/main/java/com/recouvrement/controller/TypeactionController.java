package com.recouvrement.controller;

import com.recouvrement.model.Typeaction;
import com.recouvrement.service.TypeactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeactions")
public class TypeactionController {

    private final TypeactionService typeactionService;

    public TypeactionController(TypeactionService typeactionService) {
        this.typeactionService = typeactionService;
    }

    // GET /api/typeactions
    @GetMapping
    public List<Typeaction> getAllTypeactions() {
        return typeactionService.getAllTypeactions();
    }

    // GET /api/typeactions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Typeaction> getTypeactionById(@PathVariable Long id) {
        return typeactionService.getTypeactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/typeactions
    @PostMapping
    public ResponseEntity<Typeaction> createTypeaction(@RequestBody Typeaction typeaction) {
        Typeaction created = typeactionService.createTypeaction(typeaction);
        return ResponseEntity.ok(created);
    }

    // PUT /api/typeactions/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Typeaction> updateTypeaction(@PathVariable Long id, @RequestBody Typeaction typeaction) {
        try {
            Typeaction updated = typeactionService.updateTypeaction(id, typeaction);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/typeactions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeaction(@PathVariable Long id) {
        typeactionService.deleteTypeaction(id);
        return ResponseEntity.noContent().build();
    }
}


package com.recouvrement.controller;

import com.recouvrement.model.NatureProduit;
import com.recouvrement.service.NatureProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nature-produits")
@CrossOrigin(origins = "*")
public class NatureProduitController {

    @Autowired
    private NatureProduitService natureProduitService;

    @GetMapping
    public List<NatureProduit> getAll() {
        return natureProduitService.getAllNatureProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NatureProduit> getById(@PathVariable Long id) {
        return natureProduitService.getNatureProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NatureProduit create(@RequestBody NatureProduit natureProduit) {
        return natureProduitService.saveNatureProduit(natureProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NatureProduit> update(@PathVariable Long id, @RequestBody NatureProduit natureProduit) {
        NatureProduit updated = natureProduitService.updateNatureProduit(id, natureProduit);
        if (updated != null) return ResponseEntity.ok(updated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        natureProduitService.deleteNatureProduit(id);
        return ResponseEntity.noContent().build();
    }
}


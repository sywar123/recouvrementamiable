package com.recouvrement.controller;

import com.recouvrement.model.StatutAction;
import com.recouvrement.service.StatutActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuts")
@CrossOrigin(origins = "*") // si tu utilises un frontend
public class StatutActionController {

    @Autowired
    private StatutActionService statutActionService;

    @GetMapping
    public List<StatutAction> getAllStatuts() {
        return statutActionService.getAllStatuts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatutAction> getStatutById(@PathVariable Long id) {
        return statutActionService.getStatutById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StatutAction createStatut(@RequestBody StatutAction statut) {
        return statutActionService.createStatut(statut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatutAction> updateStatut(@PathVariable Long id, @RequestBody StatutAction statut) {
        StatutAction updated = statutActionService.updateStatut(id, statut);
        if (updated != null) return ResponseEntity.ok(updated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatut(@PathVariable Long id) {
        statutActionService.deleteStatut(id);
        return ResponseEntity.noContent().build();
    }
}


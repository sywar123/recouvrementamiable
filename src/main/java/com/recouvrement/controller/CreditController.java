package com.recouvrement.controller;

import com.recouvrement.model.Credit;
import com.recouvrement.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping
    public List<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping
    public Credit saveCredit(@RequestBody Credit credit) {
        return creditService.saveCredit(credit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getCreditById(@PathVariable Long id) {
        return creditService.getCreditById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Partie ajoutée : Endpoint pour récupérer la liste des crédits impayés (reste > 0)
    @GetMapping("/impayes")
    public List<Credit> getCreditsImpayes() {
        return creditService.getCreditsImpayes();
    }
}

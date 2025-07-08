package com.recouvrement.controller;

import com.recouvrement.model.Compte;
import com.recouvrement.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @PostMapping
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteService.getCompteById(id);
    }
}

package com.recouvrement.service;

import com.recouvrement.model.Compte;
import com.recouvrement.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte getCompteById(Long id) {
        return compteRepository.findById(id).orElse(null);
    }
}


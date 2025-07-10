package com.recouvrement.service;

import com.recouvrement.model.Credit;
import com.recouvrement.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Optional<Credit> getCreditById(Long id) {
        return creditRepository.findById(id);
    }

    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    // Méthode ajoutée pour récupérer la liste des crédits impayés (reste > 0)
    public List<Credit> getCreditsImpayes() {
        return creditRepository.findByResteGreaterThan(0.0);
    }
}


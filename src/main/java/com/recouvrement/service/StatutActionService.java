package com.recouvrement.service;

import com.recouvrement.model.StatutAction;
import com.recouvrement.repository.StatutActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatutActionService {

    @Autowired
    private StatutActionRepository statutActionRepository;

    public List<StatutAction> getAllStatuts() {
        return statutActionRepository.findAll();
    }

    public Optional<StatutAction> getStatutById(Long id) {
        return statutActionRepository.findById(id);
    }

    public StatutAction createStatut(StatutAction statut) {
        return statutActionRepository.save(statut);
    }

    public StatutAction updateStatut(Long id, StatutAction updatedStatut) {
        return statutActionRepository.findById(id).map(statut -> {
            statut.setLibelle(updatedStatut.getLibelle());
            return statutActionRepository.save(statut);
        }).orElse(null);
    }

    public void deleteStatut(Long id) {
        statutActionRepository.deleteById(id);
    }
}

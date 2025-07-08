package com.recouvrement.service;

import com.recouvrement.model.NatureProduit;
import com.recouvrement.repository.NatureProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NatureProduitService {

    @Autowired
    private NatureProduitRepository natureProduitRepository;

    public List<NatureProduit> getAllNatureProduits() {
        return natureProduitRepository.findAll();
    }

    public Optional<NatureProduit> getNatureProduitById(Long id) {
        return natureProduitRepository.findById(id);
    }

    public NatureProduit saveNatureProduit(NatureProduit natureProduit) {
        return natureProduitRepository.save(natureProduit);
    }

    public NatureProduit updateNatureProduit(Long id, NatureProduit newNatureProduit) {
        return natureProduitRepository.findById(id).map(np -> {
            np.setLibelle(newNatureProduit.getLibelle());
            return natureProduitRepository.save(np);
        }).orElse(null);
    }

    public void deleteNatureProduit(Long id) {
        natureProduitRepository.deleteById(id);
    }
}

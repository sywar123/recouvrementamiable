package com.recouvrement.service;

import com.recouvrement.model.Produit;
import com.recouvrement.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit updatedProduit) {
        return produitRepository.findById(id).map(prod -> {
            prod.setNomProduit(updatedProduit.getNomProduit());
            prod.setNatureProduit(updatedProduit.getNatureProduit());
            return produitRepository.save(prod);
        }).orElse(null);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}

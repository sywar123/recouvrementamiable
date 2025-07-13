package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class NatureProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle; // Exemple : "Crédit consommation", "Crédit immobilier", etc.

   

    // Constructeurs
    public NatureProduit() {
    }

    public NatureProduit(String libelle) {
        this.libelle = libelle;
    }

    public NatureProduit(Long id, String libelle, List<Produit> produits, List<ActionRecouvrement> actions) {
        this.id = id;
        this.libelle = libelle;
        
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

   
}


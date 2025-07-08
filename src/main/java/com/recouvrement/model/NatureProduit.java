package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class NatureProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle; // Exemple : "Crédit consommation", "Crédit immobilier", etc.

    @OneToMany(mappedBy = "natureProduit")
    private List<Produit> produits;

    @OneToMany(mappedBy = "natureProduit")
    private List<ActionRecouvrement> actions;

    // Constructeurs
    public NatureProduit() {
    }

    public NatureProduit(String libelle) {
        this.libelle = libelle;
    }

    public NatureProduit(Long id, String libelle, List<Produit> produits, List<ActionRecouvrement> actions) {
        this.id = id;
        this.libelle = libelle;
        this.produits = produits;
        this.actions = actions;
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

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<ActionRecouvrement> getActions() {
        return actions;
    }

    public void setActions(List<ActionRecouvrement> actions) {
        this.actions = actions;
    }
}


package com.recouvrement.model;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomProduit;

    @ManyToOne
    @JoinColumn(name = "nature_produit_id")
    private NatureProduit natureProduit;

    // Constructeurs
    public Produit() {
    }

    public Produit(String nomProduit, NatureProduit natureProduit) {
        this.nomProduit = nomProduit;
        this.natureProduit = natureProduit;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public NatureProduit getNatureProduit() {
        return natureProduit;
    }

    public void setNatureProduit(NatureProduit natureProduit) {
        this.natureProduit = natureProduit;
    }
}

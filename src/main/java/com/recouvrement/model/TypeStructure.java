package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TypeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "typeStructure")
    private List<Structure> structures;

    // Constructeurs
    public TypeStructure() {}

    public TypeStructure(String libelle) {
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

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }
}


package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "type_structure_id")
    private TypeStructure typeStructure;

  
    // Constructeurs
    public Structure() {}

    public Structure(String nom, TypeStructure typeStructure) {
        this.libelle = libelle;
        this.typeStructure = typeStructure;
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

    public TypeStructure getTypeStructure() {
        return typeStructure;
    }

    public void setTypeStructure(TypeStructure typeStructure) {
        this.typeStructure = typeStructure;
    }

   
}


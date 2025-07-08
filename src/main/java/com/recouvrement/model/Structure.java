package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "type_structure_id")
    private TypeStructure typeStructure;

    @OneToMany(mappedBy = "structure")
    private List<Compte> comptes;

    // Constructeurs
    public Structure() {}

    public Structure(String nom, TypeStructure typeStructure) {
        this.nom = nom;
        this.typeStructure = typeStructure;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeStructure getTypeStructure() {
        return typeStructure;
    }

    public void setTypeStructure(TypeStructure typeStructure) {
        this.typeStructure = typeStructure;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}


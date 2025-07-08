package com.recouvrement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StatutAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle; //  "en cours", "concrétisé", "non concrétisé"

    @OneToMany(mappedBy = "statutAction")
    private List<ActionRecouvrement> actions;

    // Constructeurs
    public StatutAction() {
    }

    public StatutAction(Long id, String libelle, List<ActionRecouvrement> actions) {
        this.id = id;
        this.libelle = libelle;
        this.actions = actions;
    }

    public StatutAction(String libelle) {
        this.libelle = libelle;
    }

    // Getters et Setters

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

    public List<ActionRecouvrement> getActions() {
        return actions;
    }

    public void setActions(List<ActionRecouvrement> actions) {
        this.actions = actions;
    }
}


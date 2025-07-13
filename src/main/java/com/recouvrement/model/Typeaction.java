package com.recouvrement.model;

import jakarta.persistence.*;

@Entity
public class Typeaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;                 // Ex : "Appel", "Lettre", "SMS"
    private String timingDeclenchement; // Ex : "immédiat", "J+3", "J+7"

    //  Constructeurs 
    public Typeaction() {}

    public Typeaction(String nom, String timingDeclenchement) {
        this.nom = nom;
        this.timingDeclenchement = timingDeclenchement;
    }

    // --- Getters / Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getTimingDeclenchement() { return timingDeclenchement; }
    public void setTimingDeclenchement(String timingDeclenchement) {
        this.timingDeclenchement = timingDeclenchement;
    }
}

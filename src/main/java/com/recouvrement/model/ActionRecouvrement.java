package com.recouvrement.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ActionRecouvrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelleAction;      // Libellé de l'action
    private String timingDeclenchement; // Timing de déclenchement (exemple : "immédiat", "à J+3", etc...)

    private BigDecimal montant;         // Montant associé à l'action

    private LocalDate dateCreation;     // Date de création de l'action
    private LocalDate dateConcretisation; // Date de concrétisation

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

    @ManyToOne
    @JoinColumn(name = "statut_action_id")
    private StatutAction statutAction;

    @ManyToOne
    @JoinColumn(name = "nature_produit_id")
    private NatureProduit natureProduit;

    // Constructeurs
    public ActionRecouvrement() {}

    public ActionRecouvrement(String libelleAction, String timingDeclenchement, BigDecimal montant,
                              LocalDate dateCreation, LocalDate dateConcretisation,
                              Credit credit, StatutAction statutAction, NatureProduit natureProduit) {
        this.libelleAction = libelleAction;
        this.timingDeclenchement = timingDeclenchement;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.dateConcretisation = dateConcretisation;
        this.credit = credit;
        this.statutAction = statutAction;
        this.natureProduit = natureProduit;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleAction() {
        return libelleAction;
    }

    public void setLibelleAction(String libelleAction) {
        this.libelleAction = libelleAction;
    }

    public String getTimingDeclenchement() {
        return timingDeclenchement;
    }

    public void setTimingDeclenchement(String timingDeclenchement) {
        this.timingDeclenchement = timingDeclenchement;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateConcretisation() {
        return dateConcretisation;
    }

    public void setDateConcretisation(LocalDate dateConcretisation) {
        this.dateConcretisation = dateConcretisation;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public StatutAction getStatutAction() {
        return statutAction;
    }

    public void setStatutAction(StatutAction statutAction) {
        this.statutAction = statutAction;
    }

    public NatureProduit getNatureProduit() {
        return natureProduit;
    }

    public void setNatureProduit(NatureProduit natureProduit) {
        this.natureProduit = natureProduit;
    }
}

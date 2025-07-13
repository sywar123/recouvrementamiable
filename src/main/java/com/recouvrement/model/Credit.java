package com.recouvrement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;           // Montant initial emprunté
    private Double montantPaye;       // Montant déjà payé
    private Double montantEchu;       // Montant dû mais impayé (échu)
    private Double montantAChoir;     // Montant encore à venir
    private Double tauxInteret;       // En %

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    // Méthodes de calcul 

    public Double getInteretTotal() {
        long duree = java.time.temporal.ChronoUnit.YEARS.between(dateDebut, dateFin);
        return (montant * tauxInteret / 100) * duree;
    }

    public Double getMontantTotalARembourser() {
        return montant + getInteretTotal();
    }

    public Double getReste() {
        return montantEchu + montantAChoir;
    }

    public Double getSommeDesMontants() {
        return montantPaye + montantEchu + montantAChoir;
    }

    //Getters et Setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Double getMontantEchu() {
        return montantEchu;
    }

    public void setMontantEchu(Double montantEchu) {
        this.montantEchu = montantEchu;
    }

    public Double getMontantAChoir() {
        return montantAChoir;
    }

    public void setMontantAChoir(Double montantAChoir) {
        this.montantAChoir = montantAChoir;
    }

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}

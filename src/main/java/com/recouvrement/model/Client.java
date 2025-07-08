package com.recouvrement.model;

import jakarta.persistence.*;

	@Entity
	public class Client {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;
	    private String prenom;
	    private String telephone;
	    private String adresse;
	    private String numeroPiece;

	    @ManyToOne
	    @JoinColumn(name = "type_piece_id")
	    private TypePiece typePiece;

	    // Getters et Setters

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

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public String getNumeroPiece() {
	        return numeroPiece;
	    }

	    public void setNumeroPiece(String numeroPiece) {
	        this.numeroPiece = numeroPiece;
	    }

	    public TypePiece getTypePiece() {
	        return typePiece;
	    }

	    public void setTypePiece(TypePiece typePiece) {
	        this.typePiece = typePiece;
	    }
	}



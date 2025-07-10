package com.recouvrement.repository;

import com.recouvrement.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    // Méthode ajoutée pour récupérer les crédits impayés (reste > 0)
    List<Credit> findByResteGreaterThan(Double montant);
}


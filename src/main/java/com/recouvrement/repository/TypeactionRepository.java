package com.recouvrement.repository;

import com.recouvrement.model.Typeaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeactionRepository extends JpaRepository<Typeaction, Long> {
    // Tu peux ajouter des méthodes spécifiques si besoin
}

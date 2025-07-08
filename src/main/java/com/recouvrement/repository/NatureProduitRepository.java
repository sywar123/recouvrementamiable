package com.recouvrement.repository;

import com.recouvrement.model.NatureProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureProduitRepository extends JpaRepository<NatureProduit, Long> {
}

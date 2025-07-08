package com.recouvrement.repository;

import com.recouvrement.model.TypeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeStructureRepository extends JpaRepository<TypeStructure, Long> {
}


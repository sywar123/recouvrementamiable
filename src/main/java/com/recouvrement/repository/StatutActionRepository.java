package com.recouvrement.repository;

import com.recouvrement.model.StatutAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutActionRepository extends JpaRepository<StatutAction, Long> {
}


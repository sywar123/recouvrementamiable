package com.recouvrement.repository;

import com.recouvrement.model.ActionRecouvrement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRecouvrementRepository extends JpaRepository<ActionRecouvrement, Long> {
}


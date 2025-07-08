package com.recouvrement.service;

import com.recouvrement.model.Credit;
import com.recouvrement.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public Credit getCreditById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }
}


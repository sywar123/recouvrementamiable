package com.recouvrement.service;

import com.recouvrement.model.Typeaction;
import com.recouvrement.repository.TypeactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeactionService {

    private final TypeactionRepository typeactionRepository;

    public TypeactionService(TypeactionRepository typeactionRepository) {
        this.typeactionRepository = typeactionRepository;
    }

    public List<Typeaction> getAllTypeactions() {
        return typeactionRepository.findAll();
    }

    public Optional<Typeaction> getTypeactionById(Long id) {
        return typeactionRepository.findById(id);
    }

    public Typeaction createTypeaction(Typeaction typeaction) {
        return typeactionRepository.save(typeaction);
    }

    public Typeaction updateTypeaction(Long id, Typeaction updatedTypeaction) {
        return typeactionRepository.findById(id)
                .map(typeaction -> {
                    typeaction.setNom(updatedTypeaction.getNom());
                    typeaction.setTimingDeclenchement(updatedTypeaction.getTimingDeclenchement());
                    return typeactionRepository.save(typeaction);
                })
                .orElseThrow(() -> new IllegalArgumentException("Typeaction non trouvé"));
    }

    public void deleteTypeaction(Long id) {
        typeactionRepository.deleteById(id);
    }
}


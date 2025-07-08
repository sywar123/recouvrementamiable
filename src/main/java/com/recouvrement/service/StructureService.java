package com.recouvrement.service;

import com.recouvrement.model.Structure;
import com.recouvrement.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructureService {

    @Autowired
    private StructureRepository repository;

    public List<Structure> getAll() {
        return repository.findAll();
    }

    public Optional<Structure> getById(Long id) {
        return repository.findById(id);
    }

    public Structure create(Structure structure) {
        return repository.save(structure);
    }

    public Structure update(Long id, Structure updated) {
        return repository.findById(id).map(s -> {
            s.setNom(updated.getNom());
            s.setTypeStructure(updated.getTypeStructure());
            return repository.save(s);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


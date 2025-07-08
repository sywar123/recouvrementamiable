package com.recouvrement.service;

import com.recouvrement.model.TypeStructure;
import com.recouvrement.repository.TypeStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeStructureService {

    @Autowired
    private TypeStructureRepository repository;

    public List<TypeStructure> getAll() {
        return repository.findAll();
    }

    public Optional<TypeStructure> getById(Long id) {
        return repository.findById(id);
    }

    public TypeStructure create(TypeStructure typeStructure) {
        return repository.save(typeStructure);
    }

    public TypeStructure update(Long id, TypeStructure updated) {
        return repository.findById(id).map(ts -> {
            ts.setLibelle(updated.getLibelle());
            return repository.save(ts);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

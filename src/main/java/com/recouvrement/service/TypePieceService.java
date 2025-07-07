package com.recouvrement.service;

import com.recouvrement.model.TypePiece;
import com.recouvrement.repository.TypePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePieceService {

    @Autowired
    private TypePieceRepository typePieceRepository;

    public List<TypePiece> getAllTypePieces() {
        return typePieceRepository.findAll();
    }

    public TypePiece saveTypePiece(TypePiece typePiece) {
        return typePieceRepository.save(typePiece);
    }

    public TypePiece getTypePieceById(Long id) {
        return typePieceRepository.findById(id).orElse(null);
    }
}


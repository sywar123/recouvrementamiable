package com.recouvrement.controller;

import com.recouvrement.model.TypePiece;
import com.recouvrement.service.TypePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/typepieces")
public class TypePieceController {

    @Autowired
    private TypePieceService typePieceService;

    @GetMapping
    public List<TypePiece> getAllTypePieces() {
        return typePieceService.getAllTypePieces();
    }

    @PostMapping
    public TypePiece saveTypePiece(@RequestBody TypePiece typePiece) {
        return typePieceService.saveTypePiece(typePiece);
    }

    @GetMapping("/{id}")
    public TypePiece getTypePiece(@PathVariable Long id) {
        return typePieceService.getTypePieceById(id);
    }
}


package com.recouvrement.controller;

import com.recouvrement.model.ActionRecouvrement;
import com.recouvrement.service.ActionRecouvrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions-recouvrement")
@CrossOrigin(origins = "*")
public class ActionRecouvrementController {

    @Autowired
    private ActionRecouvrementService actionService;

    @GetMapping
    public List<ActionRecouvrement> getAllActions() {
        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionRecouvrement> getActionById(@PathVariable Long id) {
        return actionService.getActionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ActionRecouvrement createAction(@RequestBody ActionRecouvrement action) {
        return actionService.saveAction(action);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActionRecouvrement> updateAction(
            @PathVariable Long id,
            @RequestBody ActionRecouvrement updatedAction
    ) {
        ActionRecouvrement updated = actionService.updateAction(id, updatedAction);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }
}

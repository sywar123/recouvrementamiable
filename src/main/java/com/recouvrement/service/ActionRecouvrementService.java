package com.recouvrement.service;

import com.recouvrement.model.ActionRecouvrement;
import com.recouvrement.repository.ActionRecouvrementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionRecouvrementService {

    @Autowired
    private ActionRecouvrementRepository actionRecouvrementRepository;

    public List<ActionRecouvrement> getAllActions() {
        return actionRecouvrementRepository.findAll();
    }

    public Optional<ActionRecouvrement> getActionById(Long id) {
        return actionRecouvrementRepository.findById(id);
    }

    public ActionRecouvrement saveAction(ActionRecouvrement action) {
        return actionRecouvrementRepository.save(action);
    }

    public ActionRecouvrement updateAction(Long id, ActionRecouvrement updatedAction) {
        return actionRecouvrementRepository.findById(id).map(action -> {
            action.setLibelleAction(updatedAction.getLibelleAction());
            action.setTimingDeclenchement(updatedAction.getTimingDeclenchement());
            action.setMontant(updatedAction.getMontant());
            action.setDateCreation(updatedAction.getDateCreation());
            action.setDateConcretisation(updatedAction.getDateConcretisation());
            action.setCredit(updatedAction.getCredit());
            action.setStatutAction(updatedAction.getStatutAction());
            action.setNatureProduit(updatedAction.getNatureProduit());
            return actionRecouvrementRepository.save(action);
        }).orElse(null);
    }

    public void deleteAction(Long id) {
        actionRecouvrementRepository.deleteById(id);
    }
}

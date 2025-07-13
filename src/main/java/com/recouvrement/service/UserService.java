package com.recouvrement.service;

import com.recouvrement.model.User;
import com.recouvrement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injection par constructeur
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Récupérer tous les users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupérer user par ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Récupérer user par matricule
    public Optional<User> getUserByMatricule(String matricule) {
        return userRepository.findByMatricule(matricule);
    }

    // Créer un nouvel user
    public User createUser(User user) {
        if (userRepository.existsByMatricule(user.getMatricule())) {
            throw new IllegalArgumentException("Matricule déjà utilisé");
        }
        return userRepository.save(user);
    }

    // Mettre à jour un user
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
            .map(user -> {
                user.setNom(updatedUser.getNom());
                user.setPrenom(updatedUser.getPrenom());
                user.setMotDePasse(updatedUser.getMotDePasse());
                user.setRole(updatedUser.getRole());
                // Ne pas modifier matricule ici ou gérer selon besoin
                return userRepository.save(user);
            }).orElseThrow(() -> new IllegalArgumentException("User non trouvé"));
    }

    // Supprimer un user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


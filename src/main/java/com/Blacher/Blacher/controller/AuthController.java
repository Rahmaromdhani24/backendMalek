package com.Blacher.Blacher.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Blacher.Blacher.Repository.UserRepository;
import com.Blacher.Blacher.models.Role;
import com.Blacher.Blacher.models.User;
import com.Blacher.Blacher.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private  final UserService userService;
    
    public AuthController(UserRepository userRepository ,UserService userService ) {
        this.userRepository = userRepository;
        this.userService = userService ; 
    }
    @GetMapping("/user/{id}")
    public String getUserRole(@PathVariable Long id) {
        return userService.getRoleByUserId(id);
    }
    @PostMapping("/user")
    public Long getUserRoless(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");

        return (userRepository.findByUsername(username).get()).getId() ; 
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        long idUser = (userRepository.findByUsername(username).get()).getId() ; 

        try {
            // Recherche de l'utilisateur dans la base de données
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

            // Vérification du mot de passe
            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("Nom d'utilisateur ou mot de passe incorrect");
            }

            // Récupérer le rôle de l'utilisateur
             String role =userService.getRoleByUserId(idUser) ; 

            // Préparation de la réponse
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Connexion réussie");
            response.put("username", username);
            response.put("role", role); // Ajout du rôle
            response.put("status", "success");

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            // Gestion des erreurs
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            // Gestion des exceptions générales
            return ResponseEntity.status(500).body(createErrorResponse("Erreur d'authentification"));
        }
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", message);
        errorResponse.put("status", "error");
        return errorResponse;
    }
}

package com.Blacher.Blacher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Blacher.Blacher.models.User;
import com.Blacher.Blacher.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Ajouter un utilisateur avec un rôle fixe
   @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user, @RequestParam String roleName) {
      try {
            User savedUser = userService.registerUser(user.getUsername(), user.getPassword(), roleName);
         // Exemple d'une réponse JSON avec un message
            return ResponseEntity.ok(new ResponseMessage("Utilisateur ajouté avec succès : " + savedUser.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
   public class ResponseMessage {
	    private String message;

	    public ResponseMessage(String message) {
	        this.message = message;
	    }

	    // Getters et setters
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	}



    // Afficher tous les utilisateurs
    @RequestMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // Afficher un utilisateur spécifique
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // Modifier un utilisateur
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            User updated = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(new ResponseMessage("Utilisateur mis à jour : " + updated.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(new ResponseMessage("Utilisateur supprimé avec succès."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
}

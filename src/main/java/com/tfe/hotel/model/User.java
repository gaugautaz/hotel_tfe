package com.tfe.hotel.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Integer id;

    @NotBlank(message = "Le nom d'utilisateur ne doit pas être vide")
    @Size(max = 255, message = "Le nom d'utilisateur ne doit pas dépasser 255 caractères")
    @Column(name = "username_users")
    private String username;

    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    @Size(max = 255, message = "Le mot de passe ne doit pas dépasser 255 caractères")
    @Column(name = "password_users")
    private String password;

    @NotBlank(message = "Le prénom ne doit pas être vide")
    @Size(max = 100, message = "Le prénom ne doit pas dépasser 100 caractères")
    @Column(name = "name_users")
    private String name;

    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    @Column(name = "surname_users")
    private String surname;

    @NotBlank(message = "L'email ne doit pas être vide")
    @Email(message = "L'email doit être valide")
    @Size(max = 150, message = "L'email ne doit pas dépasser 150 caractères")
    @Column(name = "email_users")
    private String email;

    @NotNull(message = "Le rôle ne doit pas être nul")
    @Column(name = "role_users")
    private Integer role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations;
}


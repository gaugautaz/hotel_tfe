package com.tfe.hotel.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservations")
    private Integer id;

    @NotBlank(message = "Le statut ne doit pas être vide")
    @Size(max = 20, message = "Le statut ne doit pas dépasser 20 caractères")
    @Column(name = "statut_reservations")
    private String statut;

    @NotNull(message = "La date de début ne doit pas être nulle")
    @Column(name = "date_debut_reservations")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotNull(message = "La date de fin ne doit pas être nulle")
    @Column(name = "date_fin_reservations")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_users")
    @NotNull(message = "L'utilisateur ne doit pas être nul")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_chambres")
    @NotNull(message = "La chambre ne doit pas être nulle")
    private Chambre chambre;
}



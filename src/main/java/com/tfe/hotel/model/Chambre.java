package com.tfe.hotel.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "chambres")
@Data
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chambres")
    private Integer id;

    @NotNull(message = "Le nombre de lits ne doit pas être nul")
    @Column(name = "lit_chambres")
    private Integer lit;

    @NotBlank(message = "Le type de chambre ne doit pas être vide")
    @Size(max = 50, message = "Le type de chambre ne doit pas dépasser 50 caractères")
    @Column(name = "type_chambres")
    private String type;

    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")
    @Column(name = "description_chambres")
    private String description;

    @NotNull(message = "Le prix ne doit pas être nul")
    @Column(name = "prix_chambres")
    private Integer prix;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations;
}



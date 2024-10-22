package com.example.LocationsBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicule")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("marque")
    private String marque;

    @JsonProperty("modele")
    @Column(nullable = false)
    private String modele;

    @JsonProperty("immatriculation")
    private String immatriculation;

    @JsonProperty("etatVehicule")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EtatVehicule etatVehicule; // Etat du véhicule (Enum : A, B, C, D)

    @JsonProperty("prixLocationJour")
    @Column(nullable = false)
    private double prixLocationJour; // Prix de location à la journée

    @JsonProperty("disponibilite")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Disponibilite disponibilite; // Disponibilité (Enum : DISPONIBLE, NON_DISPONIBLE)

    @JsonProperty("typeVehicule")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeVehicule typeVehicule; // Type de véhicule (Enum : Voiture, Camion, Utilitaire, Moto)

    public enum EtatVehicule {
        A, B, C, D
    }

    public enum Disponibilite {
        DISPONIBLE, NON_DISPONIBLE
    }

    public enum TypeVehicule {
        VOITURE, CAMION, UTILITAIRE, MOTO
    }
}


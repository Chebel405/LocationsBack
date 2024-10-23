package com.example.LocationsBack.Service;

import com.example.LocationsBack.Entity.Client;
import com.example.LocationsBack.Entity.Vehicule;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Optional;
@ComponentScan
public interface VehiculeService {
    Vehicule createVehicule(Vehicule vehicule);

    List<Vehicule> findAll();

    Optional<Vehicule> findById(Long id);

    List<Vehicule>findByType(Vehicule.TypeVehicule typeVehicule);

    List<Vehicule> findByEtat(Vehicule.EtatVehicule etatVehicule);

    List<Vehicule> findByDisponibilite(Vehicule.Disponibilite disponibilite);

    Vehicule save(Vehicule vehicule);

    void deleteById(Long id);

    Vehicule updateVehicule(Long id, Vehicule vehicule);

}

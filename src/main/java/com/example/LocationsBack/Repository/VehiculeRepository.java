package com.example.LocationsBack.Repository;

import com.example.LocationsBack.Entity.Client;
import com.example.LocationsBack.Entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByTypeVehicule(Vehicule.TypeVehicule typeVehicule);
    List<Vehicule> findByEtatVehicule(Vehicule.EtatVehicule etatVehicule);
}

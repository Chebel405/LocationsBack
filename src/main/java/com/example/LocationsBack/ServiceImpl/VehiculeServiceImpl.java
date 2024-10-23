package com.example.LocationsBack.ServiceImpl;

import com.example.LocationsBack.Entity.Vehicule;
import com.example.LocationsBack.Repository.VehiculeRepository;
import com.example.LocationsBack.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    @Autowired
    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule createVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> findById(Long id) {
        return Optional.ofNullable(vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé")));
    }

    @Override
    public List<Vehicule> findByType(Vehicule.TypeVehicule typeVehicule) {
        return vehiculeRepository.findByTypeVehicule(typeVehicule);
    }

    @Override
    public List<Vehicule> findByEtat(Vehicule.EtatVehicule etatVehicule) {
        return vehiculeRepository.findByEtatVehicule(etatVehicule);
    }

    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteById(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return vehiculeRepository.findById(id)
                .map(existingVehicule -> {
                    existingVehicule.setMarque(vehicule.getMarque());
                    existingVehicule.setModele(vehicule.getModele());
                    existingVehicule.setImmatriculation(vehicule.getImmatriculation());
                    existingVehicule.setEtatVehicule(vehicule.getEtatVehicule());
                    existingVehicule.setPrixLocationJour(vehicule.getPrixLocationJour());
                    existingVehicule.setDisponibilite(vehicule.getDisponibilite());
                    existingVehicule.setTypeVehicule(vehicule.getTypeVehicule());
                    return vehiculeRepository.save(existingVehicule);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé"));
    }
}

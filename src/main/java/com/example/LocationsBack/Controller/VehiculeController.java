package com.example.LocationsBack.Controller;

import com.example.LocationsBack.Entity.Vehicule;
import com.example.LocationsBack.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicules")
@CrossOrigin(origins = "http://localhost:5173")
public class VehiculeController {
    @Autowired
    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("")
    public List<Vehicule>findAll() {
        return vehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehicule> findById(@PathVariable Long id){
        return vehiculeService.findById(id);
    }

    @GetMapping("/type/{typeVehicule}")
    public List<Vehicule> findByType(@PathVariable Vehicule.TypeVehicule typeVehicule){
        return vehiculeService.findByType(typeVehicule);
    }

    @GetMapping("/etat/{etatVehicule}")
    public List<Vehicule> findByEtat(@PathVariable Vehicule.EtatVehicule etatVehicule){
        return vehiculeService.findByEtat(etatVehicule);
    }

    @GetMapping("/disponibilite/{disponibilite}")
    public List<Vehicule> findByDisponibilite(@PathVariable Vehicule.Disponibilite disponibilite){
        return vehiculeService.findByDisponibilite(disponibilite);
    }

    @PostMapping("/")
    public Vehicule createVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.createVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule){
        return vehiculeService.updateVehicule(id, vehicule);
    }

    @PostMapping("")
    public Vehicule save(@RequestBody Vehicule vehicule){
        return vehiculeService.save(vehicule);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id){
        vehiculeService.deleteById(id);
    }
}

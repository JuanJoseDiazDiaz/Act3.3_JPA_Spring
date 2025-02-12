package com.example.demo_api_Concesionario.controller;

import com.example.demo_api_Concesionario.model.Coche;
import com.example.demo_api_Concesionario.model.Conductor;
import com.example.demo_api_Concesionario.repository.ConductorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductorController {
    @Autowired
    private ConductorRepositorio repositorioConductor;

    // Obtener todos los conductores
    @GetMapping
    public List<Conductor> allConductores() {
        return repositorioConductor.findAll();
    }

    // Obtener un conductor por su id
    @GetMapping("/{idConductor}")
    public Conductor findConductorById(@PathVariable int idConductor) {
        return repositorioConductor.getById(idConductor);
    }

    // Obtener coches de un conductor específico
    @GetMapping("/{idConductor}/coches")
    public List<Coche> cochesConductores(@PathVariable int idConductor) {
        Conductor conductor = repositorioConductor.getById(idConductor);
        return conductor.getCoches();  // Asumiendo que tienes una relación bidireccional entre Conductor y Coche
    }

    // Obtener conductores cuyo nombre empieza con "J", apellido con "E" y tienen menos de 5 años de carnet
    @GetMapping("/search")
    public List<Conductor> findConductoresByNombreAndApellidoAndAnyosCarnet(
            @RequestParam String nombre, @RequestParam String apellido, @RequestParam int anyos) {
        return repositorioConductor.findByNombreConductorStartingWithAndApellidoConductorStartingWithAndAnyosCarnetConductorLessThan(nombre, apellido, anyos);
    }

    // Obtener conductores con entre 3 y 6 años de carnet
    @GetMapping("/yearsBetween")
    public List<Conductor> findConductoresByAnyosCarnetBetween(@RequestParam int min, @RequestParam int max) {
        return repositorioConductor.findByAnyosCarnetConductorBetween(min, max);
    }

    // Actualizar la dirección de un conductor
    @PutMapping("/updateDireccion/{idConductor}")
    public void updateDireccionConductor(
            @PathVariable int idConductor,
            @RequestParam String calle,
            @RequestParam String cp,
            @RequestParam String localidad,
            @RequestParam String provincia) {

        repositorioConductor.updateDireccionConductor(idConductor, calle, cp, localidad, provincia);
    }
}

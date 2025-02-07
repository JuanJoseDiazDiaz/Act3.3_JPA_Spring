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

    @GetMapping
    public List<Conductor> allConductores() {
        return repositorioConductor.findAll();
    }

    @GetMapping("/{idConductor}")
    public Conductor findConductorById(@RequestParam long id) {
        return repositorioConductor.getById(id);
    }

    @GetMapping("/findInfoConductores")
    public List<Coche> cochesConductores(@RequestParam long id){
         List<Coche> coches = (List<Coche>) findConductorById(id);
         return coches;
    }
}

package com.example.demo_api_Concesionario.controller;

import com.example.demo_api_Concesionario.model.Coche;
import com.example.demo_api_Concesionario.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coches")
public class CocheController {
    @Autowired
    private CocheRepository repository;

    // Obtener todos los coches
    @GetMapping("/findAll")
    public List<Coche> findAll() {
        return repository.findAll();
    }

    // Buscar coches por el id del conductor
    @GetMapping("/byConductor/{idConductor}")
    public List<Coche> findByConductoresIdConductor(@PathVariable int idConductor) {
        return repository.findByConductores_IdConductor(idConductor);
    }

    // Obtener un coche por su id
    @GetMapping("/findByIdCoche/{idCoche}")
    public Coche findByIdCoche(@PathVariable int idCoche) {
        return repository.findByIdCoche(idCoche);
    }

    // Obtener coches cuyo conductor tiene más de X años de carnet
    @GetMapping("/byConductorYearsGreaterThan/{anyos}")
    public List<Coche> findByConductoresAnyosCarnetGreaterThan(@PathVariable int anyos) {
        return repository.findByConductores_AnyosCarnetConductorGreaterThan(anyos);
    }

    // Obtener coches cuyo conductor tiene menos de 25 años
    @GetMapping("/byConductorUnder25")
    public List<Coche> findByConductoresUnder25() {
        return repository.findByConductores_AnyosCarnetConductorLessThan(25);
    }

    // Eliminar un coche por id
    @DeleteMapping("/delete/{idCoche}")
    public void deleteByIdCoche(@PathVariable int idCoche) {
        repository.deleteByIdCoche(idCoche);
    }

}

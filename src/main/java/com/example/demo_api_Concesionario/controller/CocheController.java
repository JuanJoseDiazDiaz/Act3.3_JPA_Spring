package com.example.demo_api_Concesionario.controller;

import com.example.demo_api_Concesionario.model.Coche;
import com.example.demo_api_Concesionario.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class CocheController {
    @Autowired
    private CocheRepository repository;

    @GetMapping("/findAll")
    public List<Coche> findAll() {
     return repository.findAll();
    }

}

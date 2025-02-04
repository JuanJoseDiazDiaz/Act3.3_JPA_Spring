package com.example.demo_api_Concesionario.controller;

import com.example.demo_api_Concesionario.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheController {
    @Autowired
    private CocheRepository repository;

}

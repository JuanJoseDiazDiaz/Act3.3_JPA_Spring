package com.example.demo_api_Concesionario.repository;

import com.example.demo_api_Concesionario.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepositorio extends JpaRepository<Conductor, Long> {
}

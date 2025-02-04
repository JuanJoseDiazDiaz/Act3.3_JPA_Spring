package com.example.demo_api_Concesionario.repository;

import com.example.demo_api_Concesionario.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}

package com.example.demo_api_Concesionario.repository;

import com.example.demo_api_Concesionario.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConductorRepositorio extends JpaRepository<Conductor, Long> {
    // 1. Obtener todos los conductores
    List<Conductor> findAll();

    // 7. Conductores cuyo nombre empieza por J, apellido por E y tienen menos de 5 años de carnet
    List<Conductor> findByNombreConductorStartingWithAndApellidoConductorStartingWithAndAnyosCarnetConductorLessThan(
            String nombre, String apellido, int anyos);

    // 8. Conductores con entre 3 y 6 años de carnet
    List<Conductor> findByAnyosCarnetConductorBetween(int min, int max);
    // 9. Actualizar dirección de un conductor
    @Modifying
    @Query("UPDATE Conductor c SET c.calleConductor = :calle, c.cpConductor = :cp, c.localidadConductor = :localidad, c.provinciaConductor = :provincia WHERE c.idConductor = :idConductor")
    void updateDireccionConductor(Long idConductor, String calle, String cp, String localidad, String provincia);
}

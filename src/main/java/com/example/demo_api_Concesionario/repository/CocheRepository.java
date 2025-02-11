package com.example.demo_api_Concesionario.repository;

import com.example.demo_api_Concesionario.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {
    // 2. Obtener todos los coches
    List<Coche> findAll();

    // Buscar coches por el id del conductor (cambiado a 'IdConductor')
    List<Coche> findByConductores_IdConductor(int idConductor);

    // 4. Conductores de un coche específico (se obtiene a través del coche)
    Coche findByIdCoche(int idCoche);

    // 5. Coches cuyo conductor tiene más de 10 años de carnet (usando la propiedad 'AnyosCarnetConductor' de Conductor)
    List<Coche> findByConductores_AnyosCarnetConductorGreaterThan(int anyos);

    // 6. Coches cuyo conductor tiene menos de 25 años (usando la propiedad 'Edad' de Conductor)
    List<Coche> findByConductores_AnyosCarnetConductorLessThan(int anyos);

    // 10. Eliminar un coche
    void deleteByIdCoche(int idCoche);
}
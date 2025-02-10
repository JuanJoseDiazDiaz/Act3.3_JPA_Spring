package com.example.demo_api_Concesionario.repository;

import com.example.demo_api_Concesionario.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    // 2. Obtener todos los coches
    List<Coche> findAll();

    // Buscar coches por el id del conductor (cambiado a 'Conductores_Id')
    List<Coche> findByConductores_Id(Long idConductor);

    // 4. Conductores de un coche específico (se obtiene a través del coche)
    Coche findByIdCoche(Long idCoche);

    // 5. Coches cuyo conductor tiene más de 10 años de carnet (usando la propiedad 'AnyosCarnet' de Conductor)
    List<Coche> findByConductores_AnyosCarnetGreaterThan(int anyos);

    // 6. Coches cuyo conductor tiene menos de 25 años (usando la propiedad 'Edad' de Conductor)
    List<Coche> findByConductores_EdadLessThan(int edad);

    // 10. Eliminar un coche
    void deleteByIdCoche(Long idCoche);
}

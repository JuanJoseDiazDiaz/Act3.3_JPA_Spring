package com.example.demo_api_Concesionario.main;

import com.example.demo_api_Concesionario.model.Coche;
import com.example.demo_api_Concesionario.model.Conductor;
import com.example.demo_api_Concesionario.repository.CocheRepository;
import com.example.demo_api_Concesionario.repository.ConductorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo_api_Concesionario")
public class Main implements CommandLineRunner {
    private final ConductorRepositorio conductorRepository;
    private final CocheRepository cocheRepository;

    public Main(ConductorRepositorio conductorRepository, CocheRepository cocheRepository) {
        this.conductorRepository = conductorRepository;
        this.cocheRepository = cocheRepository;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> mostrarConductores();
                case 2 -> mostrarCoches();
                case 3 -> {
                    System.out.print("Ingrese el ID del conductor: ");
                    int idConductor = scanner.nextInt();
                    mostrarCochesPorConductor(idConductor);
                }
                case 4 -> {
                    System.out.print("Ingrese el ID del coche: ");
                    int idCoche = scanner.nextInt();
                    mostrarConductorPorCoche(idCoche);
                }
                case 5 -> mostrarCochesConductorMayor10Anios();
                case 6 -> mostrarCochesConductorMenor25Anios();
//                case 7 -> mostrarConductoresJE5Anios();
                case 8 -> mostrarConductores3A6Anios();
                case 9 -> {
                    System.out.print("Ingrese el ID del conductor: ");
                    int idConductor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nueva calle: ");
                    String calle = scanner.nextLine();
                    System.out.print("Nuevo código postal: ");
                    String cp = scanner.nextLine();
                    System.out.print("Nueva localidad: ");
                    String localidad = scanner.nextLine();
                    System.out.print("Nueva provincia: ");
                    String provincia = scanner.nextLine();
                    actualizarDireccionConductor(idConductor, calle, cp, localidad, provincia);
                }
                case 10 -> {
                    System.out.print("Ingrese el ID del coche a eliminar: ");
                    int idCoche = scanner.nextInt();
                    eliminarCoche(idCoche);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void mostrarConductores() {
        List<Conductor> conductores = conductorRepository.findAll();
        conductores.forEach(System.out::println);
    }

    private void mostrarCoches() {
        List<Coche> coches = cocheRepository.findAll();
        coches.forEach(System.out::println);
    }

    private void mostrarCochesPorConductor(int idConductor) {
        List<Coche> coches = cocheRepository.findByConductores_IdConductor(idConductor);
        if (coches.isEmpty()) {
            System.out.println("No se encontraron coches para este conductor.");
        } else {
            coches.forEach(System.out::println);
        }
    }

    private void mostrarConductorPorCoche(int idCoche) {
        Optional<Coche> coche = cocheRepository.findById(idCoche);
        if (coche.isPresent() && coche.get().getConductores() != null) {
            System.out.println("Conductor: " + coche.get().getConductores());
        } else {
            System.out.println("No se encontró conductor para este coche.");
        }
    }

    private void mostrarCochesConductorMayor10Anios() {
        List<Coche> coches = cocheRepository.findByConductores_AnyosCarnetConductorGreaterThan(10);
        coches.forEach(System.out::println);
    }

    private void mostrarCochesConductorMenor25Anios() {
        List<Coche> coches = cocheRepository.findByConductores_AnyosCarnetConductorLessThan(35);
        coches.forEach(System.out::println);
    }

    private void mostrarConductoresJE5Anios() {
        List<Conductor> conductores = conductorRepository.findByNombreConductorStartingWithAndApellidoConductorStartingWithAndAnyosCarnetConductorLessThan(
                "J", "E", 5);
        conductores.forEach(System.out::println);
    }

    private void mostrarConductores3A6Anios() {
        List<Conductor> conductores = conductorRepository.findByAnyosCarnetConductorBetween(3, 6);
        conductores.forEach(System.out::println);
    }

    private void actualizarDireccionConductor(int idConductor, String calle, String cp, String localidad, String provincia) {
        conductorRepository.updateDireccionConductor(idConductor, calle, cp, localidad, provincia);
        System.out.println("Dirección actualizada con éxito.");
    }

    private void eliminarCoche(int idCoche) {
        cocheRepository.deleteById(idCoche);
        System.out.println("Coche eliminado con éxito.");
    }

    //Metodo Imprimir menu:
    public void menu() {
        System.out.println("\n===== MENÚ DE USUARIO =====");
        System.out.println("1. Mostrar todos los conductores");
        System.out.println("2. Mostrar todos los coches");
        System.out.println("3. Mostrar coches de un conductor específico");
        System.out.println("4. Mostrar conductor de un coche específico");
        System.out.println("5. Mostrar coches cuyos conductores tienen más de 10 años de carnet");
        System.out.println("6. Mostrar coches cuyos conductores tienen menos de 25 años");
        System.out.println("7. Mostrar conductores cuyo nombre empieza por 'J', apellido por 'E' y tienen menos de 5 años de carnet");
        System.out.println("8. Mostrar conductores con entre 3 y 6 años de carnet");
        System.out.println("9. Actualizar dirección de un conductor");
        System.out.println("10. Eliminar un coche");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

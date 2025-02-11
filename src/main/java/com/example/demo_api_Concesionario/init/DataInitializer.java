package com.example.demo_api_Concesionario.init;

import com.example.demo_api_Concesionario.model.Coche;
import com.example.demo_api_Concesionario.model.Conductor;
import com.example.demo_api_Concesionario.repository.CocheRepository;
import com.example.demo_api_Concesionario.repository.ConductorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private CocheRepository repositoryCoche;
    @Autowired
    private ConductorRepositorio conductorRepositorio;

    private final ConductorRepositorio conductorRepository;
    private final CocheRepository cocheRepository;

    public DataInitializer(ConductorRepositorio conductorRepository, CocheRepository cocheRepository) {
        this.conductorRepository = conductorRepository;
        this.cocheRepository = cocheRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // todo -> Coches
        Coche coche1 = new Coche();
        coche1.setMatricula("2342FFD");
        coche1.setMarca("Seat");
        coche1.setModelo("Leon");


        Coche coche2 = new Coche();
        coche2.setMatricula("5678GHT");
        coche2.setMarca("Volkswagen");
        coche2.setModelo("Golf");

        Coche coche3 = new Coche();
        coche3.setMatricula("8910JKL");
        coche3.setMarca("Ford");
        coche3.setModelo("Focus");


        Coche coche4 = new Coche();
        coche4.setMatricula("2341XYZ");
        coche4.setMarca("BMW");
        coche4.setModelo("Serie 3");


        Coche coche5 = new Coche();
        coche5.setMatricula("4567QWE");
        coche5.setMarca("Audi");
        coche5.setModelo("A4");


        Coche coche6 = new Coche();
        coche6.setMatricula("8765RTY");
        coche6.setMarca("Mercedes");
        coche6.setModelo("Clase A");


        Coche coche7 = new Coche();
        coche7.setMatricula("1122VVV");
        coche7.setMarca("Peugeot");
        coche7.setModelo("308");


        Coche coche8 = new Coche();
        coche8.setMatricula("3344ASD");
        coche8.setMarca("Renault");
        coche8.setModelo("Megane");


        Coche coche9 = new Coche();
        coche9.setMatricula("5566DSF");
        coche9.setMarca("Toyota");
        coche9.setModelo("Corolla");


        Coche coche10 = new Coche();
        coche10.setMatricula("7788GBB");
        coche10.setMarca("Honda");
        coche10.setModelo("Civic");


        //Guardar Los Coches
        repositoryCoche.save(coche1);
        repositoryCoche.save(coche2);
        repositoryCoche.save(coche3);
        repositoryCoche.save(coche4);
        repositoryCoche.save(coche5);
        repositoryCoche.save(coche6);
        repositoryCoche.save(coche7);
        repositoryCoche.save(coche8);
        repositoryCoche.save(coche9);
        repositoryCoche.save(coche10);


        // todo -> Conductores
        Conductor conductor = new Conductor();
        conductor.setNombreConductor("Iker");
        conductor.setApellidoConductor("Silva");
        conductor.setCalleConductor("Avenida Carnaval");
        conductor.setCpConductor("21410");
        conductor.setLocalidadConductor("Isla Cristina");
        conductor.setProvinciaConductor("Huelva");
        conductor.setNumeroConductor(6772312);
        conductor.setAnyosCarnetConductor(2);
        conductor.setFechaConductor(LocalDate.of(2021, 03, 1));

        Conductor conductor2 = new Conductor();
        conductor2.setNombreConductor("Sergio");
        conductor2.setApellidoConductor("Rojas");
        conductor2.setCalleConductor("Calle Lepero");
        conductor2.setCpConductor("21440");
        conductor2.setLocalidadConductor("Lepe");
        conductor2.setProvinciaConductor("Huelva");
        conductor2.setNumeroConductor(6772343);
        conductor2.setAnyosCarnetConductor(5);
        conductor2.setFechaConductor(LocalDate.of(2020, 04, 24));

        Conductor conductor3 = new Conductor();
        conductor3.setNombreConductor("José");
        conductor3.setApellidoConductor("Seda");
        conductor3.setCalleConductor("Calle de la Moda");
        conductor3.setCpConductor("21400");
        conductor3.setLocalidadConductor("Ayamonte");
        conductor3.setProvinciaConductor("Huelva");
        conductor3.setNumeroConductor(6772367);
        conductor3.setAnyosCarnetConductor(1);
        conductor3.setFechaConductor(LocalDate.of(2024, 02, 14));

        Conductor conductor4 = new Conductor();
        conductor4.setNombreConductor("Roberto");
        conductor4.setApellidoConductor("Rivero");
        conductor4.setCalleConductor("Calle España");
        conductor4.setCpConductor("21410");
        conductor4.setLocalidadConductor("Isla Cristina");
        conductor4.setProvinciaConductor("Huelva");
        conductor4.setNumeroConductor(6772389);
        conductor4.setAnyosCarnetConductor(20);
        conductor4.setFechaConductor(LocalDate.of(2016, 12, 30));

        Conductor conductor5 = new Conductor();
        conductor5.setNombreConductor("Jorge");
        conductor5.setApellidoConductor("Gomez");
        conductor5.setCalleConductor("Calle de la Moda");
        conductor5.setCpConductor("21440");
        conductor5.setLocalidadConductor("Lepe");
        conductor5.setProvinciaConductor("Huelva");
        conductor5.setNumeroConductor(6772387);
        conductor5.setAnyosCarnetConductor(10);
        conductor5.setFechaConductor(LocalDate.of(2015, 7, 4));

        conductor.getCoches().addAll(List.of(coche1, coche2));
        conductor2.getCoches().addAll(List.of(coche3, coche4));
        conductor3.getCoches().addAll(List.of(coche5, coche6));
        conductor4.getCoches().addAll(List.of(coche7, coche8));
        conductor5.getCoches().addAll(List.of(coche9, coche10));

        coche1.getConductores().add(conductor);
        coche2.getConductores().add(conductor2);
        coche3.getConductores().add(conductor3);
        coche4.getConductores().add(conductor4);
        coche5.getConductores().add(conductor5);
        coche6.getConductores().add(conductor);
        coche7.getConductores().add(conductor2);
        coche8.getConductores().add(conductor3);
        coche9.getConductores().add(conductor4);
        coche10.getConductores().add(conductor5);

        conductorRepositorio.saveAll(List.of(conductor, conductor2, conductor3, conductor4, conductor5));

    }


}

package com.example.demo_api_Concesionario.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoche;
    private String matricula;
    private String marca;
    private String modelo;

    @ManyToMany(mappedBy = "coches", fetch = FetchType.EAGER)
    private List<Conductor> conductores = new ArrayList<>();



    public void setIdCoche(Long idCoche) {
        this.idCoche = idCoche;
    }

    public Long getIdCoche() {
        return idCoche;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }
}

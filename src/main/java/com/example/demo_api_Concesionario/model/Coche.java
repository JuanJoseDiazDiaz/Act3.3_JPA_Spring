package com.example.demo_api_Concesionario.model;

import jakarta.persistence.*;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoche;
    private String matricula;
    private String marca;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

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

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}

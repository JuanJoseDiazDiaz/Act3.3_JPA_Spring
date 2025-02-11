package com.example.demo_api_Concesionario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConductor;
    private String nombreConductor;
    private String apellidoConductor;
    private String calleConductor;
    private String cpConductor;
    private String localidadConductor;
    private String provinciaConductor;
    private int numeroConductor;
    private int anyosCarnetConductor;
    private LocalDate fechaConductor;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "conductor_conduce_coche",
            joinColumns = @JoinColumn(name = "id_Conductor"),
            inverseJoinColumns = @JoinColumn(name = "id_Coche")
    )
    List<Coche> coches = new ArrayList<>();


    public void setIdConductor(int id) {
        this.idConductor = id;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public String getApellidoConductor() {
        return apellidoConductor;
    }

    public void setApellidoConductor(String apellidoConductor) {
        this.apellidoConductor = apellidoConductor;
    }

    public String getCalleConductor() {
        return calleConductor;
    }

    public void setCalleConductor(String calleConductor) {
        this.calleConductor = calleConductor;
    }

    public String getCpConductor() {
        return cpConductor;
    }

    public void setCpConductor(String cpConductor) {
        this.cpConductor = cpConductor;
    }

    public String getLocalidadConductor() {
        return localidadConductor;
    }

    public void setLocalidadConductor(String localidadConductor) {
        this.localidadConductor = localidadConductor;
    }

    public String getProvinciaConductor() {
        return provinciaConductor;
    }

    public void setProvinciaConductor(String provinciaConductor) {
        this.provinciaConductor = provinciaConductor;
    }

    public int getNumeroConductor() {
        return numeroConductor;
    }

    public void setNumeroConductor(int numeroConductor) {
        this.numeroConductor = numeroConductor;
    }

    public int getAnyosCarnetConductor() {
        return anyosCarnetConductor;
    }

    public void setAnyosCarnetConductor(int anyosCarnetConductor) {
        this.anyosCarnetConductor = anyosCarnetConductor;
    }

    public LocalDate getFechaConductor() {
        return fechaConductor;
    }

    public void setFechaConductor(LocalDate fechaConductor) {
        this.fechaConductor = fechaConductor;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "idConductor=" + idConductor +
                ", nombre='" + nombreConductor + '\'' +
                ", apellido='" + apellidoConductor + '\'' +
                ", anyosCarnet=" + anyosCarnetConductor +
                ", fechaNacimiento=" + fechaConductor +
                ", coches=" + coches.stream().map(Coche::getIdCoche).toList() +  // Evitar recursión infinita
                '}';
    }
}

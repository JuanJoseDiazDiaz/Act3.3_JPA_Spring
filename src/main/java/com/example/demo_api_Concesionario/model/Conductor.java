package com.example.demo_api_Concesionario.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;
    private String nombreConductor;
    private String apellidoConductor;
    private String calleConductor;
    private String cpConductor;
    private String localidadConductor;
    private String provinciaConductor;
    private int numeroConductor;
    private int anyosCarnetConductor;
    private Date fechaConductor;

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<Coche> coches;

    public Conductor() {
        coches = new ArrayList<>();
    }

    public void setIdConductor(Long id) {
        this.idConductor = id;
    }

    public Long getIdConductor() {
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

    public Date getFechaConductor() {
        return fechaConductor;
    }

    public void setFechaConductor(Date fechaConductor) {
        this.fechaConductor = fechaConductor;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public void addCoche(Coche coche){
        this.coches.add(coche);
        coche.setConductor(this);
    }

    public void removeCoche(Coche coche){
        this.coches.remove(coche);
        coche.setConductor(null);
    }
}

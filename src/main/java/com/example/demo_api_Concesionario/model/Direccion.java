package com.example.demo_api_Concesionario.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Embeddable
public class Direccion {
    @JoinColumn(name = "calle_Conductor")
    private String calleConductor;
    @JoinColumn(name = "cp_Conductor")
    private String cpConductor;
    @JoinColumn(name = "localidad_Conductor")
    private String localidadConductor;
    @JoinColumn(name = "provincia_Conductor")
    private String provinciaConductor;

    public Direccion() {
    }

    public Direccion(String calleConductor, String cpConductor, String localidadConductor, String provinciaConductor) {
        this.calleConductor = calleConductor;
        this.cpConductor = cpConductor;
        this.localidadConductor = localidadConductor;
        this.provinciaConductor = provinciaConductor;
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
}

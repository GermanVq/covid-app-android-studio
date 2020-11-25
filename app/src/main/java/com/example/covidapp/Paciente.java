package com.example.covidapp;

public class Paciente {
    private int foto;
    private String nombre;
    private String eps;
    private String motivio;
    private String direccion;
    private String numero;
    private String contacto;
    private String antecendentes;
    private String sintomas;
    private Boolean covid;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getMotivio() {
        return motivio;
    }

    public void setMotivio(String motivio) {
        this.motivio = motivio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getAntecendentes() {
        return antecendentes;
    }

    public void setAntecendentes(String antecendentes) {
        this.antecendentes = antecendentes;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Boolean getCovid() {
        return covid;
    }

    public void setCovid(Boolean covid) {
        this.covid = covid;
    }

    public Paciente(int foto, String nombre, String eps, String motivio, String direccion, String numero, String contacto, String antecendentes, String sintomas, Boolean covid) {
        this.foto = foto;
        this.nombre = nombre;
        this.eps = eps;
        this.motivio = motivio;
        this.direccion = direccion;
        this.numero = numero;
        this.contacto = contacto;
        this.antecendentes = antecendentes;
        this.sintomas = sintomas;
        this.covid = covid;
    }
}
package com.uniovi.notaneitor.entities;

import com.sun.source.doctree.SeeTree;

public class Proffesor {

    private long id;
    private String dni;
    private String name;
    private String apellidos;
    private String categoria;


    public Proffesor(){}

    public Proffesor(long id, String dni, String name, String apellidos, String categoria) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.apellidos = apellidos;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Proffesor{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

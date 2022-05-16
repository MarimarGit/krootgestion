package com.inserta.krootgestionv2.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="tipo_actividad")
public class TipoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;
    private String descripcion;
    //Relación OneToMany con Actividad
    @OneToMany(mappedBy = "tipoActividad", cascade = CascadeType.ALL)
    private Set<Actividad> actividades = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
        //le asigno a la actividad el tipo actual
        for (Actividad actividad : actividades) {
            actividad.setTipoActividad(this);
        }
    }
}

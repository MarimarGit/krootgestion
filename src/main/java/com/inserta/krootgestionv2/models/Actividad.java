package com.inserta.krootgestionv2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "actividades", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idEstado;
    @NotNull
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    //Relación ManyToOne con TipoActividad
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoActividad tipoActividad;

    //private int idTipo;
    private String lugar;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaInscripcionInicio;
    private LocalDateTime fechaInscripcionFin;
    private int aforoMinimo;
    private int aforoMaximo;
    private int numParticipantes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDateTime getFechaInscripcionInicio() {
        return fechaInscripcionInicio;
    }

    public void setFechaInscripcionInicio(LocalDateTime fechaInscripcionInicio) {
        this.fechaInscripcionInicio = fechaInscripcionInicio;
    }

    public LocalDateTime getFechaInscripcionFin() {
        return fechaInscripcionFin;
    }

    public void setFechaInscripcionFin(LocalDateTime fechaInscripcionFin) {
        this.fechaInscripcionFin = fechaInscripcionFin;
    }

    public int getAforoMinimo() {
        return aforoMinimo;
    }

    public void setAforoMinimo(int aforoMinimo) {
        this.aforoMinimo = aforoMinimo;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }
}
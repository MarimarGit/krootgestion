package com.inserta.krootgestionv2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idEstado;
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private TipoActividad tipoActividad;
    private String lugar;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaInscripcionInicio;
    private LocalDateTime fechaInscripcionFin;
    private int aforoMinimo;
    private int aforoMaximo;
    @Column(nullable = true)
    private int numParticipantes;
}
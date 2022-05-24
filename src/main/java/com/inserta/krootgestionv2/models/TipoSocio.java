package com.inserta.krootgestionv2.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tipo_socio")
public class TipoSocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;

    @OneToMany(mappedBy = "tipoSocio", cascade = CascadeType.ALL)
    private Set<Socio> socios = new HashSet<>();

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

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;

        //Cada vez que yo meta un socio en el array, debo indicarle que el tipoSocio
        //que le voy a poner que es el actual, el objeto actual en el que estoy.
        for (Socio socio : socios) {
            socio.setTipoSocio(this);
        }
    }

    @Override
    public String toString() {
        return "TipoSocio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", socios=" + socios +
                '}';
    }
}

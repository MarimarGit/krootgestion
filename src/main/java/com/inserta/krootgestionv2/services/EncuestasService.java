package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Encuesta;

import java.util.List;

public interface EncuestasService {
    /**
     * Obtiene la encuesta por el nombre de esta
     * @param nombre String con el nombre de la encuesta
     * @return Encuesta con el nombre de la encuesta
     */
    public List<Encuesta> findByNombre(String nombre);
}

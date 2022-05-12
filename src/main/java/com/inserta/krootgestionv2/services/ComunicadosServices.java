package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Comunicado;

import java.util.List;

public interface ComunicadosServices {

    public List<Comunicado> getComunicadosByIdActividad(int id);

}

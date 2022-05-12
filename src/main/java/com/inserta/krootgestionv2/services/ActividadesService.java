package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Actividad;

import java.time.LocalDate;
import java.util.List;

public interface ActividadesService {

    public List<Actividad> getActividadesByTipo(int tipo);


}

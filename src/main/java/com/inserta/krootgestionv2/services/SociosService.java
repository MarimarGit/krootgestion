package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Socio;

import java.time.LocalDateTime;
import java.util.List;

public interface SociosService {
    public List<Socio> getSociosByFechaUltimoAcceso(LocalDateTime fecha);
}

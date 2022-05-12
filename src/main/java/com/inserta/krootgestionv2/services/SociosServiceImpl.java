package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Socio;
import com.inserta.krootgestionv2.repos.SociosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SociosServiceImpl implements SociosService{
    @Autowired
    private SociosRepo sociosRepo;

    @Override
    public List<Socio> getSociosByFechaUltimoAcceso(LocalDateTime fecha) {
        return sociosRepo.findByFechaUltimoAcceso(fecha);
    }
}

package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Encuesta;
import com.inserta.krootgestionv2.repos.EncuestasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EncuestasServicesImpl implements EncuestasService {
    @Autowired
    private EncuestasRepo encuestasRepo;

    @Override
    public List<Encuesta> findByNombre(String nombre) {
        return encuestasRepo.findByNombre(nombre);
    }
}


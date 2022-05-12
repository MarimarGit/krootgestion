package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Actividad;
import com.inserta.krootgestionv2.repos.ActividadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ActividadesServicesImpl implements ActividadesService {

    @Autowired
    private ActividadesRepo actividadesRepo;




    @Override
    public List<Actividad> getActividadesByTipo(int tipo) {
        return actividadesRepo.findByIdTipo(tipo);
    }




}


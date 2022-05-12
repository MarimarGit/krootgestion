package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Comunicado;
import com.inserta.krootgestionv2.repos.ComunicadosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComunicadosServicesImpl implements ComunicadosServices {

    @Autowired
    private ComunicadosRepo comunicadosRepo;

    @Override
    public List<Comunicado> getComunicadosByIdActividad(int id) {
        return  comunicadosRepo.findComunicadoByIdActividad(id);
    }
}

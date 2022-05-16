package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.repos.ComunicadosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunicadosServicesImpl implements ComunicadosServices {

    @Autowired
    private ComunicadosRepo comunicadosRepo;

}

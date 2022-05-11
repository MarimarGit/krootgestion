package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.repos.EncuestasRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class EncuestasServicesImpl implements EncuestasService {
    @Autowired
    private EncuestasRepo encuestasRepo;
}

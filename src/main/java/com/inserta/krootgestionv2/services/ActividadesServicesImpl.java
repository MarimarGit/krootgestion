package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.repos.ActividadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActividadesServicesImpl implements ActividadesService {

    @Autowired
    private ActividadesRepo actividadesRepo;


}

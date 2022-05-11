package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.repos.SociosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SociosServiceImpl implements SociosService{
    @Autowired
    private SociosRepo sociosRepo;
}

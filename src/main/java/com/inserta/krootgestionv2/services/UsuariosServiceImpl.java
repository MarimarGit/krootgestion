package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Usuario;
import com.inserta.krootgestionv2.repos.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Override
    public Usuario getUsuarioByEmailAndPass(String email, String pass) {
        return usuariosRepo.findByEmailAndPass(email, pass);
    }

}

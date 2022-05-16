package com.inserta.krootgestionv2;

import com.inserta.krootgestionv2.models.Usuario;
import com.inserta.krootgestionv2.services.UsuariosServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KrootGestionV2ApplicationTests {

    @Autowired
    private UsuariosServices usuariosService;

    @Test
    public void testGetUsuarioByEmailAndPass() {
        String email = "vaquita@hotmail.com";
        String pass = "mu";
        Usuario usuario = usuariosService.getUsuarioByEmailAndPass(email, pass);
        assertNotNull(usuario);
    }

}

package com.inserta.krootgestionv2.services;

import com.inserta.krootgestionv2.models.Usuario;

public interface UsuariosService {

    /**
     * Obtiene un usuario con el emmail y la contraseña indicados
     * @param email El email del usuario
     * @param pass La contraseña del usuario
     * @return  El usuario con el email y la contraseña indicados
     */
    public Usuario getUsuarioByEmailAndPass(String email, String pass);


}

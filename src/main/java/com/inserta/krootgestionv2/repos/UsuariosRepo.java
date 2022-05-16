package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuariosRepo extends JpaRepository<Usuario, Integer> {
    /**
     * Obtiene el usuario con email y pass pasados por parámetros
     * @param email String con el email
     * @param pass String con el pass
     * @return Usuario con email y pass indicados
     */
    public Usuario findByEmailAndPass(String email, String pass);


    /**
     * Comprueba si existe un usuario con email y pass pasados por parámetros
     * @param email String con el email
     * @param pass String con el pass
     * @return true si existe o false en caso contrario
     */
    public boolean existsByEmailAndPass(String email, String pass);


    public Usuario findByEmail(String email);
    public Usuario findByPass(String pass);
    public List<Usuario> findByEmailStartingWithAndEstado(String email, int estado);
    public List<Usuario> findByFechaUltimoAcceso(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha);



}

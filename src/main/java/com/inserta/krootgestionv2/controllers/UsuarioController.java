package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.Usuario;
import com.inserta.krootgestionv2.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuariosService usuariosServices;

    @PostMapping("/login")
    public String login(@RequestParam String pass, @RequestParam String email, HttpSession session, Model model){
        Usuario usuarioEncontrado = usuariosServices.getUsuarioByEmailAndPass(email, pass);
        System.out.println(usuarioEncontrado);

        //Validamos el usuario encontrado, si existe nos vamos al menú, si no volvemos al login
        if (usuarioEncontrado != null) {
            //Si existe...
            session.setAttribute("usuarioActivo", usuarioEncontrado );
            return "index";
        } else {
            //No existe...
            model.addAttribute("mensaje","Correo y/o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}

package com.fschmatz.login_service.controller;


import com.fschmatz.login_service.entity.Usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.fschmatz.login_service.repository.UsuarioRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Transactional
@RequestMapping("/login")
public class LoginController {

    UsuarioRepository repository;

    //PAGINA PRINCIPAL
    @GetMapping("/")
    public String homePage() {
        return "login";
    }

    @GetMapping("/checkin")
    public String checkinPage() {
        return "checkLogin";
    }

    //http://localhost:9093/login/1/2          para testes
    @PostMapping("/loginUser")
    public String login(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributesl){

        Usuario existingUsuarioLogin = repository.findByLogin(usuario.getLogin());
        System.out.println("USARIO LOGIN --> "+existingUsuarioLogin.toString());

        if(existingUsuarioLogin.getSenha().equals(usuario.getSenha())){
            System.out.println("ok");
            return "redirect:http://localhost:9090/usuario/homeUsuario/"+existingUsuarioLogin.getId_usuario();
        }
        return "Usuario não encontrado";
    }

    @PostMapping("/loginUserCheckin")
    public String loginUserCheckin(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributesl){

        Usuario existingUsuarioLogin = repository.findByLogin(usuario.getLogin());
        System.out.println("USARIO LOGIN --> "+existingUsuarioLogin.toString());

        if(existingUsuarioLogin.getSenha().equals(usuario.getSenha())){
            System.out.println("ok");
            return "redirect:http://localhost:9090/evento/listarTodosEventosFazerCheckin/"+existingUsuarioLogin.getId_usuario();
        }
        return "Usuario não encontrado";
    }
}

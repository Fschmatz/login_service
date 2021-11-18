package com.fschmatz.login_service.controller;


import com.fschmatz.login_service.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fschmatz.login_service.repository.UsuarioRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Transactional
@RequestMapping("/login")
public class UsuarioController {

    UsuarioRepository repository;

    /*//LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }*/

    //PAGINA PRINCIPAL
    @GetMapping("/")
    public String homePage() {
        return "login";
    }


    //http://localhost:9093/login/1/2             !!! tem 2 "eu" não usar
    //checar usuario e retornar true or false
    @RequestMapping ("/{login}/{senha}")
    public Boolean login(@PathVariable("login") String login, @PathVariable("senha") String senha, Model model){

        Optional<Usuario> existingUsuarioLogin = repository.findByLogin(login);
        if(existingUsuarioLogin.get().getSenha().equals(senha)){
            System.out.println("ok");
            return true;
        }
        System.out.println("nope");
        return false;

        /* if (existingUsuarioLogin.get().getSenha().isEmpty()) {
            return "OK achou";
        }

        return "redirect:https://g1.globo.com/";*/

        /*System.out.println("NOME --> "+existingUsuarioLogin.get().getNome());
        System.out.println("LOGIN --> "+existingUsuarioLogin.get().getLogin());
        System.out.println("SENHA --> "+existingUsuarioLogin.get().getSenha());*/
    }

    @RequestMapping ("/oi")
    public String oi(){
        return "oi";
    }


}
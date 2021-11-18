package com.fschmatz.login_service.login;

import com.fschmatz.login_service.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.fschmatz.login_service.repository.UsuarioRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException("Invalido");
        }

        return usuario.get();
    }

}

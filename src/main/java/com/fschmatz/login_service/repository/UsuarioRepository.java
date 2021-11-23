package com.fschmatz.login_service.repository;
import com.fschmatz.login_service.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByLogin(String login);
}

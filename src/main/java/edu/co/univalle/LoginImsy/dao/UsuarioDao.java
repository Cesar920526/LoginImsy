package edu.co.univalle.LoginImsy.dao;

import edu.co.univalle.LoginImsy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username); // De acuerdo al username me trae el objeto persona
}

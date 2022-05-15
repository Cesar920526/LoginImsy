package edu.co.univalle.LoginImsy.dao;

import edu.co.univalle.LoginImsy.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

//Clase para poder traer los elementos persona desde la base de datos
public interface PersonaDao extends JpaRepository<Persona, Long> {
}

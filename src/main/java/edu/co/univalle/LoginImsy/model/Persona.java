package edu.co.univalle.LoginImsy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data //Notacion de lombok para creacion de los parametros de la clase.
@Entity // Se convierte la clase en entidad
@Table(name = "persona") // Sirve para que no se tengan problemas al llamar la tabla de la BD
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //Metodo para generar la llave primaria.
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @NotEmpty
    private String identificacion;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String email;
    @NotEmpty
    private String login;
    @NotEmpty
    private String contraseña;
    @NotEmpty
    private String rol;
}

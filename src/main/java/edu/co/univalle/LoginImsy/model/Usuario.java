package edu.co.univalle.LoginImsy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String contraseña;
    @OneToMany //Relacion que lleva con la tabla Rol
    @JoinColumn(name="id_usuario") //Es para saber donde tiene que ir esa relacion
    private List<Rol> roles; //Lista de objetos para recuperar roles asociados a un user

}

package edu.co.univalle.LoginImsy.controller;

import edu.co.univalle.LoginImsy.model.Persona;
import edu.co.univalle.LoginImsy.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired // Inyeccion de dependencia.
    private PersonaService personaService;

    /*@GetMapping("/login")
    public String login(@AuthenticationPrincipal User user){
        return "login";
    }*/

    @GetMapping("/")
    public String inicio(@AuthenticationPrincipal User user){
        return "index";
    }

    @GetMapping("/Registro")
    public String registro(Persona persona){
        return "Registro";
    }

    @PostMapping("/Guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/Modificar")
    public String modificar(Persona persona, Model model){
        var personas = personaService.listarPersonas();
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("personas", personas);
        model.addAttribute("persona", persona);
        return "Modificar";
    }

    @GetMapping("/Eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/Registro";
    }

}

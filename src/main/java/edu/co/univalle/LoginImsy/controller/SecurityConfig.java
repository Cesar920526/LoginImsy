package edu.co.univalle.LoginImsy.controller;

import edu.co.univalle.LoginImsy.encoder.BCPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCPasswordEncoder bcPasswordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(bcPasswordEncoder.passwordEncoder());
    }

    @Override //Metodo para realizar la autorizacion de roles para que vean ciertas instancias de paginas
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/Registro/**", "/Modificar/**", "/Eliminar")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER", "ADMIN")
                    .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                ;
    }

}

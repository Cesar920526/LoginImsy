package edu.co.univalle.LoginImsy.security;

import edu.co.univalle.LoginImsy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UsuarioService usuarioService;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/Modificar*","/Registro*").access("hasRole('ADMIN')")
                        .anyRequest().authenticated()
                        .and()
                .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/index")
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .and()
                .logout()
                        .permitAll()
                        .logoutSuccessUrl("/login?logout");
    }

    //Crea el encriptador de contraseñas
    public BCryptPasswordEncoder passwordEncoder(){
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }
}

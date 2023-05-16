package br.com.fiap.Ondoor.services;

import br.com.fiap.Ondoor.exceptions.ObjectNotFoundException;
import br.com.fiap.Ondoor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationService implements UserDetailsService {

    @Autowired
    public UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUserName(username).orElseThrow(() -> new ObjectNotFoundException("Usuário inexistente"));
    }
}

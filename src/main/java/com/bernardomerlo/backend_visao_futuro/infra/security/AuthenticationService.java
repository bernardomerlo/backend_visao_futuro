package com.bernardomerlo.backend_visao_futuro.infra.security;

import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.dto.RegisterDTO;
import com.bernardomerlo.backend_visao_futuro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = repository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Dados inválidos!");
        }
        return user;
    }

    public void registerUser(RegisterDTO registerDTO) {
        if (userRepository.findByEmail(registerDTO.email()) != null) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        String encodedPassword = passwordEncoder.encode(registerDTO.password());
        User user = new User(null, registerDTO.name(), registerDTO.cpf(), registerDTO.email(), encodedPassword);
        userRepository.save(user);
    }
}

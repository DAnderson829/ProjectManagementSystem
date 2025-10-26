package com.dylan.ProjectManagementSystem.auth;

import com.dylan.ProjectManagementSystem.config.JwtService;
import com.dylan.ProjectManagementSystem.exception.EmailAlreadyExistsException;
import com.dylan.ProjectManagementSystem.exception.UsernameAlreadyExistsException;
import com.dylan.ProjectManagementSystem.user.Role;
import com.dylan.ProjectManagementSystem.user.User;
import com.dylan.ProjectManagementSystem.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo repo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        if(repo.findByUsername(request.getUsername()).isPresent()){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }

        if(repo.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getUsername()))
                .role(Role.USER)
                .build();

        repo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repo.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

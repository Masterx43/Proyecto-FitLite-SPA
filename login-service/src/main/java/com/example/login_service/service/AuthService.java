package com.example.login_service.service;

import org.springframework.stereotype.Service;

import com.example.login_service.controller.AuthResponse;
import com.example.login_service.controller.RegisterRequest;
import com.example.login_service.model.Cliente;
import com.example.login_service.model.Rol;
import com.example.login_service.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        Cliente cliente = Cliente.builder()
                .pnombre(request.getPnombre())
                .snombre(request.getSnombre())
                .appaterno(request.getAppaterno())
                .apmaterno(request.getApmaterno())
                .edad(request.getEdad())
                .email(request.getEmail())
                .password(request.getPassword())
                .telefono(request.getTelefono())
                .direccion(request.getDireccion())
                .rol(Rol.CLIENTE)
                .build();

        clienteRepository.save(cliente);

        return AuthResponse.builder()
            .token(jwtService.getToken(cliente))
            .build();
    }

    public AuthResponse login() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}

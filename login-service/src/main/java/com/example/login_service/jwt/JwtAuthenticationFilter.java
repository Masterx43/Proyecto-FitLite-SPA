package com.example.login_service.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component          // [OncePerRequestFilter] Clase abstracta para filtros personalizados (se utiliza para asegurar que el filtro se ejecute sólo una vez)
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Override // Método que realizará filtros relacionados al token
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String token = getTokenFromRequest(request);

        if (token == null) { // Si es nulo, le devuelve el control a la cadena de filtros.
            filterChain.doFilter(request, response);
            return;
        }
        
        filterChain.doFilter(request, response);
    }

    // Método para conseguir el token, que se encuentra en el encabezado del request.
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION); // HttpHeaders debe ser importado de SpringBoot
        
        // Verifica que el encabezado no esté vacio && que empiece con "Bearer "; formato estándar para tokens JWT en APIs REST).
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            // Extrae solo el token, eliminando el prefijo "Bearer ". EJ de token: [Bearer eyJhbGciOiJIUzI1NiIsInR...]
            return authHeader.substring(7);
        }
        return null;
    }
}
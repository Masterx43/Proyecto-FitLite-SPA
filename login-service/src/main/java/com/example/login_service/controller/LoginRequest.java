package com.example.login_service.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // TODO: para que es esto.
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String email;
    String password;
}

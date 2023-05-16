package br.com.fiap.Ondoor.entities;

public record Token(
        String token,
        String type,
        String prefix
) {}

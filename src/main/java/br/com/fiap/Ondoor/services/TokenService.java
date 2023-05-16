package br.com.fiap.Ondoor.services;

import br.com.fiap.Ondoor.entities.Credential;
import br.com.fiap.Ondoor.entities.Token;
import br.com.fiap.Ondoor.entities.User;
import br.com.fiap.Ondoor.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    public Token generateToken(@Valid Credential credential) {
        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withSubject(credential.email())
                .withIssuer("Ondoor")
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .sign(alg)
                ;
        return new Token(token, "JWT", "Bearer");
    }

    public User getValidateUser(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var userName = JWT.require(alg)
                .withIssuer("Ondoor")
                .build()
                .verify(token)
                .getSubject()
                ;

        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new JWTVerificationException("Invalid user"));
    }


}

package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Credential;
import br.com.fiap.Ondoor.entities.Restaurant;
import br.com.fiap.Ondoor.entities.User;
import br.com.fiap.Ondoor.repositories.UserRepository;
import br.com.fiap.Ondoor.services.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repo;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/signUp")
    public ResponseEntity<User> registrar(@RequestBody @Valid User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credential credential) {
        manager.authenticate(credential.toAuthentication());
        var token = tokenService.generateToken(credential);
        return ResponseEntity.ok(token);
    }

    @GetMapping
    public Page<User> findAll(@PageableDefault(size = 5) Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User ads = repo.findById(id).get();

        if (ads == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(ads);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody @Valid User User) {
        repo.save(User);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid User User) {
        log.info("alterando endereço com id " + id);
        var ads = repo.findById(id);

        if (ads.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(ads.get());
        User.setId(id);
        repo.save(User);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

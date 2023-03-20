package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    List<User> Users = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(Users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = Users.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody User user) {
        Users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody User user) {
        log.info("alterando endereço com id " + id);
        User obj = Users.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Users.remove(obj);
        user.setId(id);
        Users.add(user);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Users.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}



